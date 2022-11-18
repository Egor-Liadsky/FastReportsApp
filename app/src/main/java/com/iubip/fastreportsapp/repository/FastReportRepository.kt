package com.iubip.fastreportsapp.repository

import com.iubip.fastreportsapp.api.ApiService
import com.iubip.fastreportsapp.model.*
import javax.inject.Inject

class FastReportRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getFolder(): Folder = apiService.getFolder()

    suspend fun getContentFolder(): ContentFolder = apiService.getContentFolder()

    suspend fun getContentReports(): ContentReport = apiService.getContentReport()

    suspend fun getContentExports(): ContentExport = apiService.getContentExport()

    suspend fun getApiKeys(): ApiKeys = apiService.getApiKey()

    suspend fun getContentGroups(): ContentGroup = apiService.getContentGroups()
}