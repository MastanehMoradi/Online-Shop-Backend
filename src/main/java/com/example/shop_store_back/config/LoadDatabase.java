package com.example.shop_store_back.config;//package org.example.configs;


import com.example.shop_store_back.data.Product;
import com.example.shop_store_back.data.ProductCategory;
import com.example.shop_store_back.data.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);



    @Bean
    CommandLineRunner initDatabase (ProductRepository repository){

        return args -> {
            logger.info("PreLoading" + repository.save(new Product("Plaid with fringes","A simple duvet cover set in fine-thread cotton quality. A pillow case with envelope opening. Thread count 144.", ProductCategory.home,"https://image.hm.com/assets/hm/f4/02/f402d78a3d15fd017237fc167c209278cece4f25_xxl-1.jpg?imwidth=1260",78,6,1000)));
            logger.info("PreLoading" + repository.save(new Product("3-part kit with lip oil","Limited Edition. Get wonderfully soft and glossy lips with these lip oils in different colors and flavors. 3x1.68 ml. Vegan.", ProductCategory.cosmetic,"https://image.hm.com/assets/hm/ed/18/ed18311ad95687d02c5ebfa52696bb62e521903f.jpg?imwidth=1536",60,6,1001)));
            logger.info("PreLoading" + repository.save(new Product("Porcelain cookie jar","A patterned porcelain cookie jar with lid. Diameter 12 cm. Height 17.5 cm.", ProductCategory.home,"https://image.hm.com/assets/hm/e9/54/e954541f5ae433084858b9afe5759ba374d14475.jpg?imwidth=1260",78,6,1002)));

            logger.info("PreLoading" + repository.save(new Product("Hair care kit","New Arrival Limited Edition. A hair care kit that includes a scalp massage brush and a microfiber hair towel.", ProductCategory.cosmetic,"https://image.hm.com/assets/hm/d2/ca/d2caa1fbc815ed8819e3a796af120fc8c2964af9.jpg?imwidth=1536",60,6,1003)));
            logger.info("PreLoading" + repository.save(new Product("Porcelain mug","A mug in porcelain with a printed motif and gold-colored edge. Height 7 cm, diameter 12 cm.", ProductCategory.home,"https://image.hm.com/assets/hm/8d/e4/8de42d4da3371a0516ec9b861b3117695c66bc1e.jpg?imwidth=1260",78,6,2000)));
            logger.info("PreLoading" + repository.save(new Product("Resekit med sminkborstar","Limited Edition. A box with four double-sided, small make-up brushes and a make-up sponge - perfect to pack into your gym bag or handbag. ",
                    ProductCategory.cosmetic,"https://image.hm.com/assets/hm/d3/22/d322cbbd45830d19a5c3a29ef5082976804f5ee2.jpg?imwidth=1260",60,6,3000)));


            logger.info("PreLoading" + repository.save(new Product("Hair and body mist","Limited Edition. Glitter mist for both body and hair for the perfect shimmery festive look. Vegan product. 100 ml.", ProductCategory.Sanitery,"https://image.hm.com/assets/hm/b5/e3/b5e37f707fa7b4fa57ad71fb81b6bbeb393b37ec.jpg?imwidth=1536",78,6,2000)));
            logger.info("PreLoading" + repository.save(new Product("Candlestick in metal","An elegant candle holder in polished metal with a round base. Soft underside that protects the surface. The diameter of the foot is 7", ProductCategory.home,"https://image.hm.com/assets/hm/7b/53/7b53d5b26e9b672a741c80138f436796c3afbc7b.jpg?imwidth=1260",60,6,3000)));
//            logger.info("PreLoading" + repository.save(new Product("product9","detail9", ProductCategory.home,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",78,6,4000)));
//            logger.info("PreLoading" + repository.save(new Product("product10","detail10", ProductCategory.cosmetic,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_-Gplr3l56huMMC3Z1eJdq1xpsxA1B73WIRYojnJsPbWgGA60f9rp_4kl2Gvy-jUlAts&usqp=CAU",60,6,5000)));
//            logger.info("PreLoading" + repository.save(new Product("product11","detail11", ProductCategory.home,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",78,6,4000)));
//            logger.info("PreLoading" + repository.save(new Product("product12","detail12", ProductCategory.cosmetic,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_-Gplr3l56huMMC3Z1eJdq1xpsxA1B73WIRYojnJsPbWgGA60f9rp_4kl2Gvy-jUlAts&usqp=CAU",60,6,6000)));
//
//
//            logger.info("PreLoading" + repository.save(new Product("product7","detail7", ProductCategory.home,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",78,6,1000)));
//            logger.info("PreLoading" + repository.save(new Product("product8","detail8", ProductCategory.cosmetic,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_-Gplr3l56huMMC3Z1eJdq1xpsxA1B73WIRYojnJsPbWgGA60f9rp_4kl2Gvy-jUlAts&usqp=CAU",60,6,4000)));
//            logger.info("PreLoading" + repository.save(new Product("product9","detail9", ProductCategory.home,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",78,6,3000)));
//            logger.info("PreLoading" + repository.save(new Product("product10","detail10", ProductCategory.cosmetic,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_-Gplr3l56huMMC3Z1eJdq1xpsxA1B73WIRYojnJsPbWgGA60f9rp_4kl2Gvy-jUlAts&usqp=CAU",60,6,5000)));
//            logger.info("PreLoading" + repository.save(new Product("product11","detail11", ProductCategory.home,"https://img.freepik.com/premium-photo/house-illustration-icon-cartoon-graphics_1070876-8889.jpg",78,6,7000)));
//            logger.info("PreLoading" + repository.save(new Product("product12","detail12", ProductCategory.cosmetic,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_-Gplr3l56huMMC3Z1eJdq1xpsxA1B73WIRYojnJsPbWgGA60f9rp_4kl2Gvy-jUlAts&usqp=CAU",60,6,3000)));



        };
    }



}
