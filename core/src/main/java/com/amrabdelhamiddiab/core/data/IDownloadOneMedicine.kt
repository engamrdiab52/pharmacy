package com.amrabdelhamiddiab.core.data

import com.amrabdelhamiddiab.core.domain.Medicine

interface IDownloadOneMedicine {
    suspend fun downloadOneMedicines(name:String):Medicine?
}