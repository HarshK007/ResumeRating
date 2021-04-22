package main_logic;

import job_description.JobDescription;
import job_description.LocationRequired;
import resume.Location;
import resume.Resume;

import java.util.HashMap;
import java.util.Map;

public class GetScoreFromLocation {

    GetScoreFromLocation(){

    }

    public static double getScoreFromLocation(Resume resume, JobDescription jobDescription) {

        double obtainedScore = 0;
        double totalScore = 0;
        Map<String, Location> resumeLocationMap = new HashMap<>();
        for (Location location: resume.getLocations()) {
            resumeLocationMap.put(location.getName(), location);
        }

        for (LocationRequired locationRequired: jobDescription.getLocationRequireds()) {
            if(resumeLocationMap.containsKey(locationRequired.getLocation())){
                obtainedScore = obtainedScore + locationRequired.getWeight();
            }
            totalScore = totalScore + locationRequired.getWeight();
        }
        if (totalScore == 0){
            return 0;
        }
        return (obtainedScore/totalScore);
    }
}
