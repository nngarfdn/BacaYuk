package com.nara.bacayuk.di

import com.nara.bacayuk.data.auth.AuthDataSource
import com.nara.bacayuk.data.report.ReportDataSource
import com.nara.bacayuk.data.report.ReportDataSourceImpl
import com.nara.bacayuk.data.student.StudentDataSource
import com.nara.bacayuk.data.student.StudentDataSourceImpl
import com.nara.bacayuk.data.user.UserDataSource
import com.nara.bacayuk.data.user.UserDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single { AuthDataSource(get()) }
    single<UserDataSource> { UserDataSourceImpl(get()) }
    single<StudentDataSource> { StudentDataSourceImpl() }
    single<ReportDataSource> { ReportDataSourceImpl() }
}