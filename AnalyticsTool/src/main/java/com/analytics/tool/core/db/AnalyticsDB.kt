package com.analytics.tool.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.analytics.tool.core.db.dao.EventDao
import com.analytics.tool.core.db.dao.SessionDao
import com.analytics.tool.core.db.entity.EventEntity
import com.analytics.tool.core.db.entity.SessionEntity


@Database(
    entities = [SessionEntity::class, EventEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AnalyticsDB : RoomDatabase() {

    abstract val eventDao: EventDao
    abstract val sessionDao: SessionDao

    companion object {
        @Volatile
        private var INSTANCE: AnalyticsDB? = null

        fun getDatabase(context: Context): AnalyticsDB {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AnalyticsDB::class.java,
                    AnalyticsDB::class.simpleName
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}