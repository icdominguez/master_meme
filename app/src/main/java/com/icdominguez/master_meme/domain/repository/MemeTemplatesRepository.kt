package com.icdominguez.master_meme.domain.repository

import com.icdominguez.master_meme.domain.model.MemeTemplate

interface MemeTemplatesRepository {
    suspend fun getMemeTemplates(): List<MemeTemplate>
}