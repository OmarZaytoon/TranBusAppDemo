package com.example.tranbusdemo.Util;

import com.example.tranbusdemo.Models.Bus;
import com.example.tranbusdemo.Models.ImageModel;
import com.example.tranbusdemo.Models.Locations;
import com.example.tranbusdemo.Models.Track;

import java.util.ArrayList;

public class CreateData {
    
    public CreateData (){
        setTracks();
     setBuses();
    }

    private void setTracks() {
        Statics.tracks=new ArrayList<>();
        Statics.tracks.add(new Track(1,"الباص السريع","Fast Bus","صويلح","وسط البلد","Swailh","Downtown",22,25, 0.5F));
        Statics.tracks.get(0).setImageUrl("http://167.71.18.14:1337/uploads/fastbus_52c1ff3fd1.png");

        Statics.tracks.add(new Track(2,"رغدان - السلط","Raghadan - Salt","رغدان","السلط","Raghadan","Salt",45,90, 1.0F));
        Statics.tracks.get(1).setImageUrl("http://167.71.18.14:1337/uploads/ragdan_salt_caca6a0196.png");

        Statics.tracks.add(new Track(3,"مأدبا - رغدان","Madaba - Raghadan","مأدبا","رغدان","Madaba","Raghadan",40,90, 1.5F));
        Statics.tracks.get(2).setImageUrl("http://167.71.18.14:1337/uploads/madaba_ragdan_0226ebc00d.png");

        Statics.tracks.add(new Track(4,"ثامن - وسط البلد","Eighth circle - Downtown","ثامن","وسط البلد","Eighth circle ","Downtown",22,30, 0.5F));
        Statics.tracks.get(3).setImageUrl("http://167.71.18.14:1337/uploads/thamen_balad_208c3aebba.png");

        Statics.tracks.add(new Track(5,"خربة السوق - وسط البلد","Khirbet Souk - Downtown","خربة السوق","وسط البلد","Khirbet Souk","Downtown",26,35, 0.5F));
        Statics.tracks.get(4).setImageUrl("http://167.71.18.14:1337/uploads/kherbeh_balad_de75cad908.png");

        Statics.tracks.add(new Track(6,"صويلح - رغدان 1","Sweileh - Raghadan 1","صويلح","رغدان","Sweileh","Raghadan",22,35, 0.5F));
        Statics.tracks.get(5).setImageUrl("http://167.71.18.14:1337/uploads/first_swailh_ragdan_fe1d435cc9.png");

        Statics.tracks.add(new Track(7,"صويلح - رغدان 2","Sweileh - Raghadan 2","صويلح","رغدان","Sweileh","Raghadan",20,30, 0.5F));
        Statics.tracks.get(6).setImageUrl("http://167.71.18.14:1337/uploads/second_swailh_balad_950275336a.png");

        Statics.tracks.add(new Track(8,"تلاع العلي - رغدان","Tla' Al-Ali - Raghadan","Tla' Al-Ali","رغدان","Tla' Al-Ali","Raghadan",34,30, 0.5F));
        Statics.tracks.get(7).setImageUrl("http://167.71.18.14:1337/uploads/tlaali_ragdan_9ffdbc26d0.png");
    }

    private void setBuses() {

        Statics.buses=new ArrayList<>();

        Statics.buses.add(new Bus(1,"Mercedes-Benz Tourismo 15","12-522345",2015,52,Statics.tracks.get(0),new Locations(1,32.012334,35.870372),new ImageModel()));
        Statics.buses.add(new Bus(2,"Mercedes-Benz Tourismo 15","15-45654",2015,52,Statics.tracks.get(0),new Locations(2,31.985961, 35.897606),new ImageModel()));
        Statics.buses.add(new Bus(3,"Mercedes-Benz Tourismo 15","21-45654",2015,52,Statics.tracks.get(0),new Locations(3,31.983058, 35.894675),new ImageModel()));

        Statics.buses.add(new Bus(4,"Daewoo GD6119H2","18-10450",2010,62,Statics.tracks.get(2),new Locations(4,31.921389, 35.939276),new ImageModel()));
        Statics.buses.add(new Bus(5,"Daewoo GD6119H2","15-45654",2010,62,Statics.tracks.get(2),new Locations(5,31.913658, 35.938917),new ImageModel()));
        Statics.buses.add(new Bus(6,"Daewoo GD6119H2","15-45654",2010,62,Statics.tracks.get(2),new Locations(6,31.900217, 35.937948),new ImageModel()));

        Statics.buses.add(new Bus(7,"Toyota Costar","25-52265",2010,32,Statics.tracks.get(3),new Locations(7,31.957260, 35.849108),new ImageModel()));
        Statics.buses.add(new Bus(8,"Toyota Costar","23-40654",2010,32,Statics.tracks.get(3),new Locations(8,31.960038, 35.866633),new ImageModel()));
        Statics.buses.add(new Bus(9,"Toyota Costar","18-95540",2010,32,Statics.tracks.get(3),new Locations(9,31.954624, 35.885815),new ImageModel()));

        Statics.buses.add(new Bus(10,"Toyota Costar","19-504345",2011,32,Statics.tracks.get(4),new Locations(10,31.877209, 35.933302),new ImageModel()));
        Statics.buses.add(new Bus(11,"Toyota Costar","21-459654",2011,32,Statics.tracks.get(4),new Locations(11,31.887959, 35.934632),new ImageModel()));
        Statics.buses.add(new Bus(12,"Toyota Costar","13-456954",2011,32,Statics.tracks.get(4),new Locations(12,31.897688, 35.938291),new ImageModel()));

        Statics.buses.add(new Bus(13,"Toyota Costar","12-522345",2009,32,Statics.tracks.get(5),new Locations(13,32.015636, 35.867500),new ImageModel()));
        Statics.buses.add(new Bus(14,"Toyota Costar","15-45654",2009,32,Statics.tracks.get(5),new Locations(14,32.011269, 35.870644),new ImageModel()));
        Statics.buses.add(new Bus(15,"Toyota Costar","15-45654",2009,32,Statics.tracks.get(5),new Locations(15,32.003381, 35.874437),new ImageModel()));

        Statics.buses.add(new Bus(16,"Toyota Costar","22-522345",2006,32,Statics.tracks.get(6),new Locations(16,31.998786, 35.880123),new ImageModel()));
        Statics.buses.add(new Bus(17,"Toyota Costar","25-45654",2006,32,Statics.tracks.get(6),new Locations(17,31.977811, 35.915103),new ImageModel()));
        Statics.buses.add(new Bus(18,"Toyota Costar","25-906654",2006,32,Statics.tracks.get(6),new Locations(18,31.974084, 35.933454),new ImageModel()));

        Statics.buses.add(new Bus(19,"Mercedes-Benz Tourismo 15","22-522345",2006,32,Statics.tracks.get(7),new Locations(19,31.998786, 35.880123),new ImageModel()));
        Statics.buses.add(new Bus(20,"Mercedes-Benz Tourismo 15","25-45654",2006,32,Statics.tracks.get(7),new Locations(21,31.977811, 35.915103),new ImageModel()));
        Statics.buses.add(new Bus(21,"Mercedes-Benz Tourismo 15","25-906654",2006,32,Statics.tracks.get(7),new Locations(22,31.974084, 35.933454),new ImageModel()));

        Statics.buses.add(new Bus(22,"Daewoo GD6119H2","18-11150",2010,62,Statics.tracks.get(1),new Locations(23,32.041239, 35.785029),new ImageModel()));
        Statics.buses.add(new Bus(23,"Daewoo GD6119H2","15-25154",2010,62,Statics.tracks.get(1),new Locations(24,32.016681, 35.866633),new ImageModel()));
        Statics.buses.add(new Bus(24,"Daewoo GD6119H2","15-65154",2010,62,Statics.tracks.get(1),new Locations(25,31.998275, 35.881059),new ImageModel()));


    }
    private void setLocations(){


    }
    private void setImages(){

    }
}
