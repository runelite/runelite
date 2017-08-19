import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("fb")
   @ObfuscatedGetter(
      intValue = -1677922001
   )
   static int field1788;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -754827007
   )
   @Export("width")
   int width;
   @ObfuscatedName("x")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "[Les;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 657142859
   )
   @Export("size")
   int size;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("sprites")
   IndexDataBase sprites;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -15134759
   )
   @Export("maxSize")
   int maxSize;

   @ObfuscatedSignature(
      signature = "(Lia;Lia;IDI)V"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1839364258"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-914932681"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1879:0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "551692709"
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

         boolean var3 = var2.method2510(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "32"
   )
   public boolean vmethod2910(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2046980984"
   )
   public boolean vmethod2905(int var1) {
      return this.textures[var1].field1880;
   }

   @ObfuscatedName("j")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1396277772"
   )
   public void method2410(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1885 != 0 && var3.loaded) {
            var3.method2509(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1285718241"
   )
   static final boolean method2426() {
      return class135.field2001;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfo;I)V",
      garbageValue = "-1659541879"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = GrandExchangeOffer.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field896 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class47.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class44.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class35.plane = var2.field918 = var4;
      if(class97.field1519[var1] != null) {
         var2.decodeApperance(class97.field1519[var1]);
      }

      class97.field1510 = 0;
      class97.field1511[++class97.field1510 - 1] = var1;
      class97.field1507[var1] = 0;
      class97.field1512 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class97.field1505[var7] = (var10 << 14) + var11 + (var9 << 28);
            class97.field1515[var7] = 0;
            class97.field1516[var7] = -1;
            class97.field1513[++class97.field1512 - 1] = var7;
            class97.field1507[var7] = 0;
         }
      }

      var0.byteAccess();
   }
}
