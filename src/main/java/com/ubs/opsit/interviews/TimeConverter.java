package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.exceptions.ApplicationException;

public interface TimeConverter {

    String convertTime(String aTime)  throws ApplicationException;
    
    public static Integer NO_OF_LIGHTS_SECOND_ROW = 4;
    public static Integer NO_OF_LIGHTS_THIRD_ROW = 4;
    public static Integer NO_OF_LIGHTS_FOURTH_ROW = 11;
    public static Integer NO_OF_LIGHTS_FIFTH_ROW = 4;

}
