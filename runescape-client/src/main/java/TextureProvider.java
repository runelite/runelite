import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "[Lji;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1619772605
   )
   @Export("width")
   int width;
   @ObfuscatedName("e")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Led;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1973110985
   )
   @Export("size")
   int size;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("sprites")
   IndexDataBase sprites;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -578120309
   )
   @Export("maxSize")
   int maxSize;

   @ObfuscatedSignature(
      signature = "(Lim;Lim;IDI)V"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1583323874"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "56"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1847:0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1718409907"
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

         boolean var3 = var2.method2495(this.brightness, this.width, this.sprites);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-30594"
   )
   public boolean vmethod2909(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "29"
   )
   public boolean vmethod2908(int var1) {
      return this.textures[var1].field1846;
   }

   @ObfuscatedName("d")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "104"
   )
   public void method2399(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1851 != 0 && var3.loaded) {
            var3.method2497(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BB)Lcd;",
      garbageValue = "73"
   )
   static Script method2414(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1858(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(WorldMapType1.method249(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }
}
