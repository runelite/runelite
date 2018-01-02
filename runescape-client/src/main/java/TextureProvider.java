import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("TextureProvider")
public class TextureProvider implements ITextureLoader {
   @ObfuscatedName("y")
   static int[][][] field1667;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Ldp;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("deque")
   Deque deque;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1055362031
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -205210017
   )
   @Export("size")
   int size;
   @ObfuscatedName("u")
   @Export("brightness")
   double brightness;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1283582721
   )
   @Export("width")
   int width;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("sprites")
   IndexDataBase sprites;

   @ObfuscatedSignature(
      signature = "(Lib;Lib;IDI)V"
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

   @ObfuscatedName("a")
   @Export("brightness")
   public void brightness(double var1) {
      this.brightness = var1;
      this.reset();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-1277684059"
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
      signature = "(IB)I",
      garbageValue = "68"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null?this.textures[var1].field1770:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-20"
   )
   public boolean vmethod2891(int var1) {
      return this.textures[var1].field1761;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-979915637"
   )
   public boolean vmethod2892(int var1) {
      return this.width == 64;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1719159317"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1206800987"
   )
   public void method2393(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.field1771 != 0 && var3.loaded) {
            var3.method2502(var1);
            var3.loaded = false;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "0"
   )
   public static int method2406(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      char var7 = 0;
      char var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         var7 = MessageNode.method1070(var9);
         var8 = MessageNode.method1070(var10);
         var9 = GrandExchangeEvents.method66(var9, var2);
         var10 = GrandExchangeEvents.method66(var10, var2);
         if(var10 != var9 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return SocketSession.method3092(var9, var2) - SocketSession.method3092(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      char var12;
      int var17;
      for(var17 = 0; var17 < var16; ++var17) {
         char var11 = var0.charAt(var17);
         var12 = var1.charAt(var17);
         if(var11 != var12 && Character.toUpperCase(var11) != Character.toUpperCase(var12)) {
            var11 = Character.toLowerCase(var11);
            var12 = Character.toLowerCase(var12);
            if(var12 != var11) {
               return SocketSession.method3092(var11, var2) - SocketSession.method3092(var12, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var18 = 0; var18 < var16; ++var18) {
            var12 = var0.charAt(var18);
            char var13 = var1.charAt(var18);
            if(var12 != var13) {
               return SocketSession.method3092(var12, var2) - SocketSession.method3092(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Lhz;",
      garbageValue = "427329279"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = VertexNormal.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "72"
   )
   static final void method2414(PacketBuffer var0) {
      for(int var1 = 0; var1 < class94.field1400; ++var1) {
         int var2 = class94.field1391[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 128) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         RSCanvas.method764(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "2"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class45.method658(var3):var3;
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
