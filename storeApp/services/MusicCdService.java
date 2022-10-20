package furkan.storeApp.services;

import furkan.storeApp.authorization.Authority;
import furkan.storeApp.entity.MusicCD;
import furkan.storeApp.person.User;
import furkan.storeApp.repository.MusicCdRepository;

import java.util.List;
import java.util.Scanner;

public class MusicCdService implements ProductService<MusicCD> {
    MusicCdRepository musicCdRepository = new MusicCdRepository();

    @Override
    public void addProduct(List<MusicCD> productList, MusicCD product, User user) {
        if (!Authority.ADD_PRODUCT.userHasPermission(user)) {
            throw new RuntimeException("User don't have permission");
        }
        musicCdRepository.addProduct(product);
        System.out.println("Music Cd Added Successfully");
    }

    @Override
    public void deleteProduct(List<MusicCD> productList, MusicCD product, User user) {
        if (!Authority.ADD_PRODUCT.userHasPermission(user)) {
            throw new RuntimeException("User don't have permission");
        }
        musicCdRepository.deleteProduct(product.getId());
        System.out.println("Music Cd Deleted Successfully");

    }

    @Override
    public List<MusicCD> getProductList() {

        return musicCdRepository.getProductList();
    }

    public MusicCD createMusicCd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id of Music Cd");
        int a = scanner.nextInt();
        String o = scanner.nextLine();
        System.out.println("Name of Music Cd:");
        String b = scanner.nextLine();
        System.out.println("Expense of Music Cd");
        int c = scanner.nextInt();
        String z = scanner.nextLine();
        System.out.println("Author of Music Cd");
        String d = scanner.nextLine();
        System.out.println("Stock of Music Cd");
        int e = scanner.nextInt();
        return new MusicCD(a, b, c, d, e);
    }
}

