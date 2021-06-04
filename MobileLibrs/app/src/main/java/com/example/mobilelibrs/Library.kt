/*
public class dbDrakorAdapter {

private String LinkMovie;
private String List;
private String FotoPemain;
private String NamaPemain;

public dbDrakorAdapter (String linkMovie, String list, String fotoPemain, String namaPemain) {
    LinkMovie = linkMovie;
    List = list;
    FotoPemain = fotoPemain;
    NamaPemain = namaPemain;
}

public class EpisodeDetails {
   // public Long chapterId;
    public String LinkMovie;
    public String List;
}
public class Episode {
    List<EpisodeDetails> episodeDetails;
}

public class PemeranDetails {
    // public Long chapterId;
    public String LinkMovie;
    public String List;
}
public class Pemeran {
    List<PemeranDetails> pemeranDetails;
}


public Map<String, Object> toMap() {
    HashMap<String, Object> result = new HashMap<>();
    result.put("List", List);
    result.put("LinkMovie", LinkMovie);
    result.put("FotoPemain", FotoPemain);
    result.put("NamaPemain", NamaPemain);
    return result;
}
}*/
package com.example.mobilelibrs

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.Calendar.YEAR


class Library {

    var LibraryName: String = ""
    var LibraryAddress: String = ""
    var LibraryCapacity: Int = 0

    var libraryList = ArrayList<String>()
    var TimeSlotList = ArrayList<String>()
    var TableList = ArrayList<String>()
    var DateList = ArrayList<String>()
    // var LibraryList = ArrayList<Library>()



    constructor(libName: String, libAddress: String, libCapacity: Int) {
        this.LibraryName = libName
        this.LibraryAddress = libAddress
        this.LibraryCapacity = libCapacity

    /*

        var dates = arrayOf("09.08.2021", "09.09.2021")
        var tslots = arrayOf("9:00-10:00", "10:00-11:00")
        var tbls = arrayOf("T1", "T2", "T3")


        for(date in dates) {
            DateList.add(date)
        }
        for(ts in tslots) {
            TimeSlotList.add(ts)
        }
        for(tb in tbls) {
            TableList.add(tb)
        }
*/
        //libraryList.add(LibraryName)
        //     LibraryList.add(Library(LibraryName, LibraryAddress, LibraryCapacity, libraryNo))
    }
}



