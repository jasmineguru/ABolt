import androidx.annotation.WorkerThread
import com.marimodev.abolt.data.daos.ExerciseDao
import com.marimodev.abolt.data.daos.SessionDao
import com.marimodev.abolt.data.daos.SessionExerciseDao
import com.marimodev.abolt.data.daos.TemplateDao
import com.marimodev.abolt.data.daos.TemplateExerciseDao
import com.marimodev.abolt.data.daos.WorkoutSetDao
import com.marimodev.abolt.data.entities.Exercise
import com.marimodev.abolt.data.entities.Session
import com.marimodev.abolt.data.entities.SessionExercise
import com.marimodev.abolt.data.entities.Template
import com.marimodev.abolt.data.entities.TemplateExercise
import com.marimodev.abolt.data.entities.WorkoutSet
import kotlinx.coroutines.flow.Flow

class AboltRepository(val exerciseDao: ExerciseDao, val sessionDao: SessionDao,
                      val templateExerciseDao: TemplateExerciseDao,
                      val sessionExerciseDao: SessionExerciseDao, val templateDao: TemplateDao,
                      val workoutSetDao: WorkoutSetDao){


    val allTemplates: Flow<List<Template>> = templateDao.getAllVisibleTemplates()
    val allExercises: Flow<List<Exercise>> = exerciseDao.getAllExercises()
    val allSessions: Flow<List<Session>> = sessionDao.getAllSessions()

    fun getSessionsByDate(date: Long) = sessionDao.getSessionByDate(date)
    fun getSetBySeshExercise(sessionExerciseId: Int) =
        workoutSetDao.getWorkoutSetBySessionExercise(sessionExerciseId)
    fun getSessionExerciseByExercise(exerciseId: Int) = sessionExerciseDao.getSessionExerciseByExercise(exerciseId)


    @WorkerThread
    suspend fun insertTemplate(template: Template) = templateDao.insertTemplate(template)
    @WorkerThread
    suspend fun insertExercise(exercise: Exercise) = exerciseDao.insertExercise(exercise)
    @WorkerThread
    suspend fun insertWorkoutSet(workoutSet: WorkoutSet) = workoutSetDao.insertWorkoutSet(workoutSet)
    @WorkerThread
    suspend fun insertSession(session: Session) = sessionDao.insertSession(session)
    @WorkerThread
    suspend fun insertSessionExercise(sessionExercise: SessionExercise) = sessionExerciseDao.insertSessionExercise(sessionExercise)
    @WorkerThread
    suspend fun insertTemplateExercise(templateExercise: TemplateExercise) = templateExerciseDao.insertTemplateExercise(templateExercise)

    @WorkerThread
    suspend fun updateTemplate(template: Template) = templateDao.updateTemplate(template)
    @WorkerThread
    suspend fun updateWorkoutSet(workoutSet: WorkoutSet) = workoutSetDao.updateWorkoutSet(workoutSet)
    @WorkerThread
    suspend fun updateSession(session: Session) = sessionDao.updateSession(session)
    @WorkerThread
    suspend fun updateSessionExercise(seshExercise: SessionExercise) = sessionExerciseDao.updateSessionExercise(seshExercise)

    @WorkerThread
    suspend fun deleteSession(session: Session) = sessionDao.deleteSession(session)
    @WorkerThread
    suspend fun deleteWorkoutSet(workoutSet: WorkoutSet) = workoutSetDao.deleteWorkoutSet(workoutSet)
    @WorkerThread
    suspend fun deleteSessionExercise(sessionExercise: SessionExercise) = sessionExerciseDao.deleteSessionExercise(sessionExercise)

}