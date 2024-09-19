public class NetflixProfileExample {
    public static void main(String[] args) {
        String[] preferences = {"Action", "Comedy"};
        NetflixProfile profile = new NetflixProfile.NetflixProfileBuilder("john_doe")
                .displayPicture("profilePic.jpg")
                .preferences(preferences)
                .build();

        System.out.println(profile);
    }
}
