import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ls")
@Implements("WorldMapArchiveLoader")
public class WorldMapArchiveLoader {
   @ObfuscatedName("o")
   @Export("cacheName")
   String cacheName;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("archive")
   AbstractArchive archive;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 624113115
   )
   @Export("percentLoaded")
   int percentLoaded;
   @ObfuscatedName("l")
   @Export("isLoaded")
   boolean isLoaded;

   @ObfuscatedSignature(
      signature = "(Lir;)V"
   )
   WorldMapArchiveLoader(AbstractArchive var1) {
      this.percentLoaded = 0;
      this.isLoaded = false;
      this.archive = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1867776989"
   )
   @Export("reset")
   void reset(String cacheName) {
      if (cacheName != null && !cacheName.isEmpty() && cacheName != this.cacheName) {
         this.cacheName = cacheName;
         this.percentLoaded = 0;
         this.isLoaded = false;
         this.load();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2019633217"
   )
   @Export("load")
   int load() {
      if (this.percentLoaded < 33) {
         if (!this.archive.tryLoadFileByNames(WorldMapCacheName.WorldMapCacheName_compositeMap.name, this.cacheName)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 33;
      }

      if (this.percentLoaded == 33) {
         if (this.archive.method9(WorldMapCacheName.WorldMapCacheName_compositeTexture.name, this.cacheName) && !this.archive.tryLoadFileByNames(WorldMapCacheName.WorldMapCacheName_compositeTexture.name, this.cacheName)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 66;
      }

      if (this.percentLoaded == 66) {
         if (!this.archive.tryLoadFileByNames(this.cacheName, WorldMapCacheName.WorldMapCacheName_labels.name)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 100;
         this.isLoaded = true;
      }

      return this.percentLoaded;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-16324"
   )
   @Export("getIsLoaded")
   boolean getIsLoaded() {
      return this.isLoaded;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1342963007"
   )
   @Export("getPercentLoaded")
   int getPercentLoaded() {
      return this.percentLoaded;
   }
}
