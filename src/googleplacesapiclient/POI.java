package googleplacesapiclient;

import java.util.List;

public class POI {
    
    private String place_id;
    private String name;
    private String icon;
    private Double latitude;
    private Double longitude;
    private String address;
    private Float rating;
    private String photo_reference;
    private Integer photo_max_width;
    private Integer photo_max_height;
    private List<Object> types;
    
    private Integer distance;
    
    public POI() {};
    
    public POI(String place_id, String name, Double latitude, Double longitude, String address, Float rating, String photo_reference, Integer photo_max_width, Integer photo_max_height) {
        
        this.place_id = place_id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.rating = rating;
        
        this.photo_reference = photo_reference;
        this.photo_max_width = photo_max_width;
        this.photo_max_height = photo_max_height;
    };
    
    public void setPlaceId(String placeId) {
        
        this.place_id = placeId;
    }
    
    public String getPlaceId() {
        
        return this.place_id;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public String getName() {
        
        return this.name;
    }
    
    public void setIcon(String icon) {
        
        this.icon = icon;
    }
    
    public String getIcon() {
        
        return this.icon;
    }
    
    public void setTypes(List<Object> types) {
        
        this.types = types;
    }
    
    public List<Object> getTypes() {
        
        return this.types;
    }
    
    public void setLatitude(Double latitude) {
        
        this.latitude = latitude;
    }
    
    public Double getLatitude() {
        
        return this.latitude;
    }
    
    public void setLongitude(Double longitude) {
        
        this.longitude = longitude;
    }
    
    public Double getLongitude() {
        
        return this.longitude;
    }
    
    public void setAddress(String address) {
        
        this.address = address;
    }
    
    public String getAddress(){
        
        return this.address;
    }
    
    public void setRating(Float rating) {
        
        this.rating = rating;
    }
    
    public Float getRating() {
        
        return this.rating;
    }
    
    public void setPhotoReference(String reference) {
        
        this.photo_reference = reference;
    }
    
    public String getPhotoReference() {
        
        return this.photo_reference;
    }
    
    public void setPhotoMaxWidth(Integer max_width) {
        
        this.photo_max_width = max_width;
    }
    
    public Integer getPhotoMaxWidth() {
        
        return this.photo_max_width;
    }
    
    public void setPhotoMaxHeight(Integer max_height) {
        
        this.photo_max_height = max_height;
    }
    
    public Integer getPhotoMaxHeight() {
        
        return this.photo_max_height;
    }
    
    public void setDistance(Integer distance) {
        
        this.distance = distance;
    }
    
    public Integer getDistance() {
        
        return this.distance;
    }
    
    @Override
    public String toString() {
        
        return this.name;
    }
}
