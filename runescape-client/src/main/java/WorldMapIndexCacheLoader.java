import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("WorldMapIndexCacheLoader")
public class WorldMapIndexCacheLoader {
   @ObfuscatedName("o")
   @Export("cacheName")
   String cacheName;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("indexCache")
   AbstractIndexCache indexCache;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 624113115
   )
   @Export("percentLoaded0")
   int percentLoaded0;
   @ObfuscatedName("l")
   @Export("isLoaded0")
   boolean isLoaded0;

   @ObfuscatedSignature(
      signature = "(Lir;)V"
   )
   WorldMapIndexCacheLoader(AbstractIndexCache var1) {
      this.percentLoaded0 = 0;
      this.isLoaded0 = false;
      this.indexCache = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1867776989"
   )
   @Export("reset")
   void reset(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.cacheName) {
            this.cacheName = var1;
            this.percentLoaded0 = 0;
            this.isLoaded0 = false;
            this.load();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2019633217"
   )
   @Export("load")
   int load() {
      if(this.percentLoaded0 < 33) {
         if(!this.indexCache.tryLoadRecordByNames(WorldMapCacheName.WorldMapCacheName_compositeMap.name, this.cacheName)) {
            return this.percentLoaded0;
         }

         this.percentLoaded0 = 33;
      }

      if(this.percentLoaded0 == 33) {
         if(this.indexCache.__ag_401(WorldMapCacheName.WorldMapCacheName_compositeTexture.name, this.cacheName) && !this.indexCache.tryLoadRecordByNames(WorldMapCacheName.WorldMapCacheName_compositeTexture.name, this.cacheName)) {
            return this.percentLoaded0;
         }

         this.percentLoaded0 = 66;
      }

      if(this.percentLoaded0 == 66) {
         if(!this.indexCache.tryLoadRecordByNames(this.cacheName, WorldMapCacheName.WorldMapCacheName_labels.name)) {
            return this.percentLoaded0;
         }

         this.percentLoaded0 = 100;
         this.isLoaded0 = true;
      }

      return this.percentLoaded0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-16324"
   )
   @Export("isLoaded")
   boolean isLoaded() {
      return this.isLoaded0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1342963007"
   )
   @Export("percentLoaded")
   int percentLoaded() {
      return this.percentLoaded0;
   }
}
