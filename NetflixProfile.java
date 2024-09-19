public class NetflixProfile {
    private final String username;
    private final String displayPicture;
    private final String[] preferences;

    private NetflixProfile(NetflixProfileBuilder builder) {
        this.username = builder.username;
        this.displayPicture = builder.displayPicture;
        this.preferences = builder.preferences.clone(); // Clone to ensure immutability
    }

    public static class NetflixProfileBuilder {
        private String username;
        private String displayPicture;
        private String[] preferences = new String[0]; // Default empty array

        public NetflixProfileBuilder(String username) {
            this.username = username;
        }

        public NetflixProfileBuilder displayPicture(String picture) {
            this.displayPicture = picture;
            return this;
        }

        public NetflixProfileBuilder preferences(String[] prefs) {
            this.preferences = prefs.clone(); // Clone to avoid external modification
            return this;
        }

        public NetflixProfile build() {
            return new NetflixProfile(this);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayPicture() {
        return displayPicture;
    }

    public String[] getPreferences() {
        return preferences.clone(); // Clone to prevent external modifications
    }

    @Override
    public String toString() {
        return "NetflixProfile{" +
                "username='" + username + '\'' +
                ", displayPicture='" + displayPicture + '\'' +
                ", preferences=" + String.join(", ", preferences) +
                '}';
    }
}
