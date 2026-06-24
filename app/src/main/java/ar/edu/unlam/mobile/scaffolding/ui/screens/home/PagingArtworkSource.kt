package ar.edu.unlam.mobile.scaffolding.ui.screens.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ar.edu.unlam.mobile.scaffolding.data.repository.ArtworkRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork

class PagingArtworkSource(
    private val repository: ArtworkRepository,
    private val limit: Int = 12,
) : PagingSource<Int, Artwork>() {
    private val seenIds = mutableSetOf<Int>()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Artwork> =
        try {
            val page = params.key ?: 1
            val artworks = repository.getArtworks(page, params.loadSize.coerceAtMost(limit))
            val newArtworks = artworks.filter { synchronized(seenIds) { seenIds.add(it.id) } }
            LoadResult.Page(
                data = newArtworks,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (artworks.isEmpty()) null else page + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    override fun getRefreshKey(state: PagingState<Int, Artwork>): Int? =
        state.anchorPosition?.let { anchor ->
            val closest = state.closestPageToPosition(anchor)
            closest?.prevKey?.plus(1) ?: closest?.nextKey?.minus(1)
        }
}
