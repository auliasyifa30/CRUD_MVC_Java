package main;

import dao.DaoAddress;
import dao.DaoProvince;
import java.util.Scanner;
import model.Address;
import model.Province;

public class Main {

    static Scanner Luv = new Scanner(System.in);

    static DaoProvince daoProvince = new DaoProvince();
    static Province province = new Province();
    static DaoAddress daoAddress = new DaoAddress();
    static Address address = new Address();

    public static void showDataPro() {
        for (Province p : daoProvince.getAll()) {
            System.out.print(p.getProvinceId() + "\t");
            System.out.println(p.getProvinceName());
        }
    }

    public static void showDataAddress() {
        for (Address a : daoAddress.getAll()) {
            System.out.print(a.getPrefix() + "\t - ");
            System.out.print(a.getAddressId() + "\t - ");
            System.out.print(a.getStreet1() + " \t - ");
            System.out.print(a.getStreet2() + "- \t ");
            System.out.println(a.getVillageId());
        }
    }

    

    public static void main(String[] args) {
        while (true) {
        System.out.println("------ PILIH TABEL ------");
        System.out.println("[1] Table Province");
        System.out.println("[2] Table Address");
        System.out.print("Pilih table [1/2] = ");
        int PilihTabel = Luv.nextInt();
    
        switch (PilihTabel) {
            case 1:
                System.out.println("\n\n");
                System.out.println("------ PILIH MENU PADA TABEL PROVINCE ------");
                System.out.println("[1] Tampilkan Data");
                System.out.println("[2] Tambah Data");
                System.out.println("[3] Ubah Data");
                System.out.println("[4] Hapus Data");
                System.out.println("[5] Keluar");
                System.out.print("Pilih menu [1-5] = ");
                int PilihMenu1 = Luv.nextInt();

                switch (PilihMenu1) {
                    case 1:
                        System.out.println("------- DATA TABLE PROVINCE -------");
                        System.out.println("ID || NAMA PROVINCE");
                        showDataPro();
                        break;

                    case 2:
                        showDataPro();
                        System.out.print("Masukkan Id Province = ");
                        province.setProvinceId(Luv.nextInt());

                        System.out.print("Masukkan Nama Provinsi = ");
                        province.setProvinceName(Luv.nextLine());
                        province.setProvinceName(Luv.nextLine());

                        System.out.println(daoProvince.insert(province) ? "Data Berhasil Ditambahkan" : "Data Tidak Berhasil Ditambahkan");
                        break;

                    case 3:
                        showDataPro();
                        System.out.print("Masukkan Nama Provinsi Baru = ");
                        province.setProvinceName(Luv.nextLine());
                        province.setProvinceName(Luv.nextLine());

                        System.out.print("Diubah pada ID =  ");
                        province.setProvinceId(Luv.nextInt());
                        System.out.println(daoProvince.update(province) ? "Data Berhasil Diubah" : "Data Tidak Berhasil Diubah");
                        break;

                    case 4:
                        showDataPro();
                        System.out.print("Pilih data yang ingin dihapus = ");
                        int province_id = Luv.nextInt();
                        province.setProvinceId(province_id);
                        System.out.println(daoProvince.delete(province) ? "Data Berhasil Dihapus" : "Data Tidak Berhasil Dihapus");
                        break;

                    default:
                        System.exit(0);
                        break;
                }
      
            case 2:
                System.out.println("------ PILIH MENU ADDRESS------");
                System.out.println("[1] Tampilkan Data");
                System.out.println("[2] Tambah Data");
                System.out.println("[3] Ubah Data");
                System.out.println("[4] Hapus Data");
                System.out.println("[5] Keluar");
                System.out.print("Pilih menu [1-5] = ");
                int PilihMenu2 = Luv.nextInt();

                switch (PilihMenu2) {
                    case 1:
                        System.out.println("------- DATA TABLE ADDRESS -------");
                        showDataAddress();
                        break;

                    case 2:
                        showDataAddress();
                        System.out.print("Masukkan Kode Prefix = ");
                        address.setPrefix(Luv.nextLine());
                        address.setPrefix(Luv.nextLine());

                        System.out.print("Masukkan ID Address = ");
                        address.setAddressId(Luv.nextInt());

                        System.out.print("Masukkan Alamat 1 = ");
                        address.setStreet1(Luv.nextLine());
                        address.setStreet1(Luv.nextLine());

                        System.out.print("Masukkan Alamat 2 = ");
                        address.setStreet2(Luv.nextLine());
                        address.setStreet2(Luv.nextLine());

                        System.out.print("Masukkan ID Village (Yang Ada Sebelumnya) = ");
                        address.setVillageId(Luv.nextInt());

                        System.out.println(daoAddress.insert(address) ? "Data Berhasil Ditambah" : "Data Tidak Berhasil Ditambah");
                        break;

                    case 3:
                        showDataAddress();
                        System.out.print("Masukkan alamat 1 yang baru = ");
                        address.setStreet1(Luv.nextLine());
                        address.setStreet1(Luv.nextLine());

                        System.out.print("Masukan ID Village Yang Baru =  ");
                        address.setVillageId(Luv.nextInt());

                        System.out.print("Diubah dari ID Address =  ");
                        address.setAddressId(Luv.nextInt());

                        System.out.println(daoAddress.update(address) ? "Data Berhasil Diubah" : "Data Tidak Berhasil Diubah");
                        break;

                    case 4:
                        showDataAddress();
                        System.out.print("Pilih data yang ingin dihapus = ");
                        int address_id = Luv.nextInt();
                        address.setAddressId(address_id);
                        System.out.println(daoAddress.delete(address) ? "Data Berhasil Dihapus" : "Dara Tidak berhasil Dihapus");
                        break;

                    default:
                        System.exit(0);
                        break;
                }
        }
        }

    }

}
