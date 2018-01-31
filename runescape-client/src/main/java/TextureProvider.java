import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field1658;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Ldv;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2098905815
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1123036141
   )
   @Export("size")
   int size;
   @ObfuscatedName("j")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1963371079
   )
   @Export("width")
   int width;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;IDI)V"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.deque = new Deque();
      this.size = 0;
      this.brightness = 1.0D;
      this.width = 128;
      this.sprites = var2;
      this.maxSize = var3;
      this.size = this.maxSize;
      this.brightness = var4;
      this.width = var6;
      int[] var7 = var1.getChilds(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.fileCount(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.textures[var7[var9]] = new Texture(var10);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2531() {
      int var1 = 0;
      int var2 = 0;
      Texture[] var3 = this.textures;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         Texture var5 = var3[var4];
         if(var5 != null && var5.fileIds != null) {
            var1 += var5.fileIds.length;
            int[] var6 = var5.fileIds;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               int var8 = var6[var7];
               if(this.sprites.method4374(var8)) {
                  ++var2;
               }
            }
         }
      }

      if(var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   @ObfuscatedName("i")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "493747558"
   )
   @Export("load")
   public int[] load(int var1) {
      Texture var2 = this.textures[var1];
      if(var2 != null) {
         if(var2.pixels != null) {
            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.method2646(this.brightness, this.width, this.sprites);
         if(var3) {
            if(this.size == 0) {
               Texture var4 = (Texture)this.deque.popTail();
               var4.resetPixels();
            } else {
               --this.size;
            }

            this.deque.addTail(var2);
            var2.loaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1826552232"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1762:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1730745843"
   )
   public boolean vmethod3012(int var1) {
      return this.textures[var1].field1756;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-468750423"
   )
   public boolean vmethod3013(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "29"
   )
   @Export("reset")
   public void reset() {
      for(int var1 = 0; var1 < this.textures.length; ++var1) {
         if(this.textures[var1] != null) {
            this.textures[var1].resetPixels();
         }
      }

      this.deque = new Deque();
      this.size = this.maxSize;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1136074177"
   )
   @Hook(
	   value = "drawAboveOverheads",
	   end = true
   )
   @Export("checkTextures")
   public void checkTextures(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1758 != 0 && var3.loaded) {
            var3.method2643(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljv;",
      garbageValue = "1579741683"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = SoundTask.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isHollow) {
            var1.clipType = 0;
            var1.blocksProjectile = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-110595508"
   )
   static void method2557() {
      for(class79 var0 = (class79)class79.field1208.getFront(); var0 != null; var0 = (class79)class79.field1208.getNext()) {
         if(var0.field1209 != null) {
            CombatInfoListHolder.field1251.method2082(var0.field1209);
            var0.field1209 = null;
         }

         if(var0.field1214 != null) {
            CombatInfoListHolder.field1251.method2082(var0.field1214);
            var0.field1214 = null;
         }
      }

      class79.field1208.clear();
   }

   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "(Lho;I)Z",
      garbageValue = "822373569"
   )
   static final boolean method2552(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field1043 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1081.method4209(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1081.method4222(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1081.method4211(false);
         }

         if(var1 == 325) {
            Client.field1081.method4211(true);
         }

         if(var1 == 326) {
            PacketNode var4 = class35.method501(ClientPacket.field2322, Client.field867.field1439);
            Client.field1081.method4212(var4.packetBuffer);
            Client.field867.method2021(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
