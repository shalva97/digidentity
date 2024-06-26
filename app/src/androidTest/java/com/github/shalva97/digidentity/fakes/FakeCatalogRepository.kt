package com.github.shalva97.digidentity.fakes

import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog

class FakeCatalogRepository(pageSize: Int = 10) : CatalogRepository {
    private val iterator = sampleCatalogs.chunked(pageSize).iterator()
    override suspend fun getItems(sinceID: String?, maxID: String?): List<Catalog> {
        return iterator.next()
    }
}

val sampleCatalogs = listOf(
    Catalog(
        text = "Elegant piece of furniture that enhances the beauty of your living space.",
        confidence = 0.93f,
        image = "https://example.com/images/elegant-furniture.jpg",
        id = "656789-ZABCD"
    ),
    Catalog(
        text = "Sample product description for a catalog item. This product is top-rated and highly recommended by customers.",
        confidence = 0.95f,
        image = "https://example.com/images/sample-product.jpg",
        id = "112345-ABCDE"
    ),
    Catalog(
        text = "Innovative gadget with cutting-edge technology, perfect for tech enthusiasts.",
        confidence = 0.92f,
        image = "https://example.com/images/tech-gadget.jpg",
        id = "267890-FGHIJ"
    ),
    Catalog(
        text = "Stylish and comfortable clothing item suitable for all seasons.",
        confidence = 0.89f,
        image = "https://example.com/images/clothing-item.jpg",
        id = "323456-KLMNO"
    ),
    Catalog(
        text = "High-performance sports equipment designed for professional athletes.",
        confidence = 0.97f,
        image = "https://example.com/images/sports-equipment.jpg",
        id = "434567-PQRST"
    ),
    Catalog(
        text = "Delicious and healthy snack option made from organic ingredients.",
        confidence = 0.91f,
        image = "https://example.com/images/healthy-snack.jpg",
        id = "545678-UVWXY"
    ),
    Catalog(
        text = "Durable and reliable tool for all your DIY projects and repairs.",
        confidence = 0.94f,
        image = "https://example.com/images/diy-tool.jpg",
        id = "767890-EFGHI"
    ),
    Catalog(
        text = "Modern home appliance that simplifies everyday tasks and saves time.",
        confidence = 0.96f,
        image = "https://example.com/images/home-appliance.jpg",
        id = "878901-JKLMN"
    ),
    Catalog(
        text = "Luxury accessory that adds a touch of elegance to any outfit.",
        confidence = 0.90f,
        image = "https://example.com/images/luxury-accessory.jpg",
        id = "989012-OPQRS"
    ),
    Catalog(
        text = "Innovative kitchen gadget that makes cooking more enjoyable and efficient.",
        confidence = 0.88f,
        image = "https://example.com/images/kitchen-gadget.jpg",
        id = "1090123-TUVWX"
    ),
    Catalog(
        text = "State-of-the-art smartwatch with multiple health tracking features.",
        confidence = 0.98f,
        image = "https://example.com/images/smartwatch.jpg",
        id = "1112345-UVWXZ"
    ),
    Catalog(
        text = "Compact and powerful blender perfect for smoothies and shakes.",
        confidence = 0.92f,
        image = "https://example.com/images/blender.jpg",
        id = "1223456-ABCDE"
    ),
    Catalog(
        text = "Eco-friendly reusable water bottle with a sleek design.",
        confidence = 0.93f,
        image = "https://example.com/images/water-bottle.jpg",
        id = "1334567-FGHIJ"
    ),
    Catalog(
        text = "Premium quality headphones with noise-canceling features.",
        confidence = 0.95f,
        image = "https://example.com/images/headphones.jpg",
        id = "1445678-KLMNO"
    ),
    Catalog(
        text = "Comfortable and supportive office chair with ergonomic design.",
        confidence = 0.94f,
        image = "https://example.com/images/office-chair.jpg",
        id = "1556789-PQRST"
    ),
    Catalog(
        text = "Advanced DSLR camera with high resolution and multiple shooting modes.",
        confidence = 0.97f,
        image = "https://example.com/images/dslr-camera.jpg",
        id = "1667890-UVWXY"
    ),
    Catalog(
        text = "Smart home thermostat that helps you save energy efficiently.",
        confidence = 0.96f,
        image = "https://example.com/images/smart-thermostat.jpg",
        id = "1778901-ZABCD"
    ),
    Catalog(
        text = "Versatile kitchen knife set with durable stainless steel blades.",
        confidence = 0.92f,
        image = "https://example.com/images/kitchen-knife-set.jpg",
        id = "1889012-EFGHI"
    ),
    Catalog(
        text = "Innovative fitness tracker that monitors your daily activities.",
        confidence = 0.93f,
        image = "https://example.com/images/fitness-tracker.jpg",
        id = "1990123-JKLMN"
    ),
    Catalog(
        text = "Portable and lightweight laptop with a high-performance processor.",
        confidence = 0.94f,
        image = "https://example.com/images/laptop.jpg",
        id = "2001234-OPQRS"
    ),
    Catalog(
        text = "Sleek and modern desk lamp with adjustable brightness settings.",
        confidence = 0.90f,
        image = "https://example.com/images/desk-lamp.jpg",
        id = "2112345-TUVWX"
    ),
    Catalog(
        text = "Comfortable memory foam mattress that ensures a good night's sleep.",
        confidence = 0.91f,
        image = "https://example.com/images/memory-foam-mattress.jpg",
        id = "2223456-ABCDE"
    ),
    Catalog(
        text = "Stylish sunglasses with UV protection and polarized lenses.",
        confidence = 0.89f,
        image = "https://example.com/images/sunglasses.jpg",
        id = "2334567-FGHIJ"
    ),
    Catalog(
        text = "High-capacity external hard drive for all your storage needs.",
        confidence = 0.96f,
        image = "https://example.com/images/external-hard-drive.jpg",
        id = "2445678-KLMNO"
    ),
    Catalog(
        text = "Ergonomic gaming chair with adjustable settings for maximum comfort.",
        confidence = 0.95f,
        image = "https://example.com/images/gaming-chair.jpg",
        id = "2556789-PQRST"
    ),
    Catalog(
        text = "Smartphone with a stunning display and advanced camera features.",
        confidence = 0.97f,
        image = "https://example.com/images/smartphone.jpg",
        id = "2667890-UVWXY"
    ),
    Catalog(
        text = "Electric toothbrush with multiple brushing modes and a long-lasting battery.",
        confidence = 0.94f,
        image = "https://example.com/images/electric-toothbrush.jpg",
        id = "2778901-ZABCD"
    ),
    Catalog(
        text = "Portable Bluetooth speaker with high-quality sound and long battery life.",
        confidence = 0.93f,
        image = "https://example.com/images/bluetooth-speaker.jpg",
        id = "2889012-EFGHI"
    ),
    Catalog(
        text = "Advanced air purifier that ensures clean and fresh air in your home.",
        confidence = 0.96f,
        image = "https://example.com/images/air-purifier.jpg",
        id = "2990123-JKLMN"
    ),
    Catalog(
        text = "Stylish handbag with multiple compartments for easy organization.",
        confidence = 0.91f,
        image = "https://example.com/images/handbag.jpg",
        id = "3001234-OPQRS"
    ),
    Catalog(
        text = "High-quality yoga mat with non-slip surface for a perfect workout.",
        confidence = 0.92f,
        image = "https://example.com/images/yoga-mat.jpg",
        id = "3112345-TUVWX"
    ),
    Catalog(
        text = "Robust and reliable power bank to keep your devices charged on the go.",
        confidence = 0.95f,
        image = "https://example.com/images/power-bank.jpg",
        id = "3323456-ABCDE"
    ),
    Catalog(
        text = "Luxury wristwatch with a classic design and durable materials.",
        confidence = 0.94f,
        image = "https://example.com/images/wristwatch.jpg",
        id = "3434567-FGHIJ"
    ),
    Catalog(
        text = "High-performance running shoes with excellent cushioning and support.",
        confidence = 0.97f,
        image = "https://example.com/images/running-shoes.jpg",
        id = "3545678-KLMNO"
    ),
    Catalog(
        text = "Smart home security camera with motion detection and night vision.",
        confidence = 0.96f,
        image = "https://example.com/images/security-camera.jpg",
        id = "3656789-PQRST"
    ),
    Catalog(
        text = "Compact digital photo frame to display your cherished memories.",
        confidence = 0.92f,
        image = "https://example.com/images/photo-frame.jpg",
        id = "3767890-UVWXY"
    ),
    Catalog(
        text = "Advanced drone with high-definition camera and easy controls.",
        confidence = 0.95f,
        image = "https://example.com/images/drone.jpg",
        id = "3878901-ZABCD"
    ),
    Catalog(
        text = "Innovative coffee maker that brews the perfect cup every time.",
        confidence = 0.94f,
        image = "https://example.com/images/coffee-maker.jpg",
        id = "3989012-EFGHI"
    ),
    Catalog(
        text = "Comfortable and stylish athletic wear for your workout sessions.",
        confidence = 0.93f,
        image = "https://example.com/images/athletic-wear.jpg",
        id = "4090123-JKLMN"
    ),
    Catalog(
        text = "High-quality luggage set for all your travel needs.",
        confidence = 0.96f,
        image = "https://example.com/images/luggage-set.jpg",
        id = "4101234-OPQRS"
    ),
    Catalog(
        text = "Innovative smart light bulb that can be controlled with your phone.",
        confidence = 0.92f,
        image = "https://example.com/images/smart-light-bulb.jpg",
        id = "4212345-TUVWX"
    )
)
