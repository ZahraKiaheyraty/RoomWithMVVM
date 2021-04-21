package com.kia.roomsample.di

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import com.kia.roomsample.common.Constanse.dataBaseName
import com.kia.roomsample.data.db.MyDao
import com.kia.roomsample.data.db.MyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMyDb(
        @ApplicationContext context: Context,
    ): MyDataBase {

        return Room
            .databaseBuilder(
                context,
                MyDataBase::class.java,
                dataBaseName
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideMyDAO(myDataBase: MyDataBase): MyDao {
        return myDataBase.getDao()
    }


     @Named("h")
    @Provides
    fun time():String{

        return ""
    }
    @Named("b")
    @Provides
    fun time2():String{

        return "chfgjgj"
    }



}