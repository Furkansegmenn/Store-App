package furkan.storeApp.repository;

import furkan.storeApp.entity.MusicCD;

import java.util.ArrayList;
import java.util.List;

public class MusicCdRepository implements ProductRepository<MusicCD> {
    static int objectCount = 0;
    List<MusicCD> musicCDList = new ArrayList<>();

    public MusicCdRepository() {
        if (objectCount > 0) {
            throw new RuntimeException("Bu objeden daha fazla oluşturamazsınız.");
        }
        musicCDList.add(new MusicCD(20001, "Another Love", 20, "Tom ODELL", 15));
        musicCDList.add(new MusicCD(20002, "Back To Black", 15, "Amy WINEHOUSE", 20));
        musicCDList.add(new MusicCD(20003, "FairyTale", 25, "Alexander RYBAK", 25));
        musicCDList.add(new MusicCD(20058, "Sivas'ın Yolları", 85, "Selda BAĞCAN", 1));
        objectCount++;
    }

    @Override
    public void addProduct(MusicCD product) {
        musicCDList.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        MusicCD musicCdForDelete = null;
        for (MusicCD musicCD : musicCDList) {
            if (musicCD.getId() == id) {
                musicCdForDelete = musicCD;
            }
        }
        musicCDList.remove(musicCdForDelete);
    }

    @Override
    public List<MusicCD> getProductList() {
        return musicCDList;
    }
}
