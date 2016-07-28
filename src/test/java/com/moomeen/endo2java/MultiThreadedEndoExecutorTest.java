package com.moomeen.endo2java;

import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.moomeen.endo2java.error.InvocationException;
import com.moomeen.endo2java.model.Workout;

@RunWith(MockitoJUnitRunner.class)
public class MultiThreadedEndoExecutorTest {
	
	@Mock
	private EndomondoSession session;
	
	private MultiThreadedEndoExecutor executor;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		executor = new MultiThreadedEndoExecutor(session);
	}
	
	@Test
	public void getAllWorkoutsTest() throws InvocationException{
		int WORKOUTS_PER_THREAD = 2;
		long FIRST_ID = 1;
		LocalDateTime FIRST_START = LocalDateTime.of(2013,01,01,12,12,12);
		long SECOND_ID = 2;
		LocalDateTime SECOND_START = LocalDateTime.of(2012,01,01,12,12,12);
		long THIRD_ID = 3;
		LocalDateTime THIRD_START = LocalDateTime.of(2011,01,01,12,12,12);
		long FOURTH_ID = 4;
		LocalDateTime FOURTH_START = LocalDateTime.of(2010,01,01,12,12,12);

		// given
		List<Workout> workouts = workouts(
				workout(FIRST_ID, FIRST_START),
				workout(SECOND_ID, SECOND_START),
				workout(THIRD_ID, THIRD_START),
				workout(FOURTH_ID, FOURTH_START));
		mockHeadersRetrieval(workouts);
		
		// when
		executor.getWorkouts(WORKOUTS_PER_THREAD);
		
		// then
		assertHeadersRetrieved();
		assertWorkoutsRetrieved(1); // first one
		assertWorkoutsRetrieved(WORKOUTS_PER_THREAD, FIRST_START); // first bunch
		assertWorkoutsRetrieved(WORKOUTS_PER_THREAD, THIRD_START); // second bunch
	}

	private void mockHeadersRetrieval(List<Workout> workouts) throws InvocationException {
		when(session.getWorkouts("simple")).thenReturn(workouts);
	}
	
	private void assertHeadersRetrieved() throws InvocationException{
		verify(session, times(1)).getWorkouts("simple"); 
	}
	
	private void assertWorkoutsRetrieved(int maxResults) throws InvocationException{
		verify(session, times(1)).getWorkouts(maxResults);
	}

	private void assertWorkoutsRetrieved(int maxResults, LocalDateTime startTime) throws InvocationException{
		verify(session, times(1)).getWorkouts(maxResults, startTime); // first bunch
	}
	
	private List<Workout> workouts(Workout... workouts){
		return Arrays.asList(workouts);
	}
	
	private Workout workout(long id, LocalDateTime startTime){
		Workout workout = mock(Workout.class);
		when(workout.getId()).thenReturn(id);
		when(workout.getStartTime()).thenReturn(startTime);
		return workout;
	}

}
