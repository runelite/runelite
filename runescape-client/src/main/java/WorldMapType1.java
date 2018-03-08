import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 1493863855
   )
   static int field414;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 566751939
   )
   int field410;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 209503163
   )
   int field404;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 978126917
   )
   int field412;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1546674837
   )
   int field406;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1694020531
   )
   int field407;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1393773187
   )
   int field408;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1305783927
   )
   int field409;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -464197131
   )
   int field413;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -984534801
   )
   int field411;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -666411947
   )
   int field405;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1173479592"
   )
   public void vmethod762(WorldMapData var1) {
      if(var1.minX > this.field409) {
         var1.minX = this.field409;
      }

      if(var1.field428 < this.field411) {
         var1.field428 = this.field411;
      }

      if(var1.minY > this.field413) {
         var1.minY = this.field413;
      }

      if(var1.field430 < this.field405) {
         var1.field430 = this.field405;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-52"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field410 && var1 < this.field410 + this.field404?var2 >> 6 >= this.field412 && var2 >> 6 <= this.field407 && var3 >> 6 >= this.field406 && var3 >> 6 <= this.field408:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "53"
   )
   public boolean vmethod764(int var1, int var2) {
      return var1 >> 6 >= this.field409 && var1 >> 6 <= this.field411 && var2 >> 6 >= this.field413 && var2 >> 6 <= this.field405;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-653420606"
   )
   public int[] vmethod765(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field409 * 64 - this.field412 * 64 + var2, var3 + (this.field413 * 64 - this.field406 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)Lik;",
      garbageValue = "-2033075237"
   )
   public Coordinates vmethod770(int var1, int var2) {
      if(!this.vmethod764(var1, var2)) {
         return null;
      } else {
         int var3 = this.field412 * 64 - this.field409 * 64 + var1;
         int var4 = this.field406 * 64 - this.field413 * 64 + var2;
         return new Coordinates(this.field410, var3, var4);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1382348566"
   )
   public void vmethod761(Buffer var1) {
      this.field410 = var1.readUnsignedByte();
      this.field404 = var1.readUnsignedByte();
      this.field412 = var1.readUnsignedShort();
      this.field406 = var1.readUnsignedShort();
      this.field407 = var1.readUnsignedShort();
      this.field408 = var1.readUnsignedShort();
      this.field409 = var1.readUnsignedShort();
      this.field413 = var1.readUnsignedShort();
      this.field411 = var1.readUnsignedShort();
      this.field405 = var1.readUnsignedShort();
      this.method264();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-654053157"
   )
   void method264() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;B)Ljava/lang/String;",
      garbageValue = "37"
   )
   public static String method287(Buffer var0) {
      String var1;
      try {
         int var2 = var0.getUSmart();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class313.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = MessageNode.getString(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   public static void method285() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method288() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         ++KeyFocusListener.keyboardIdleTicks;
         KeyFocusListener.field611 = KeyFocusListener.field610;
         KeyFocusListener.field600 = 0;
         int var1;
         if(KeyFocusListener.field603 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               KeyFocusListener.keyPressed[var1] = false;
            }

            KeyFocusListener.field603 = KeyFocusListener.field602;
         } else {
            while(KeyFocusListener.field603 != KeyFocusListener.field602) {
               var1 = KeyFocusListener.field597[KeyFocusListener.field602];
               KeyFocusListener.field602 = KeyFocusListener.field602 + 1 & 127;
               if(var1 < 0) {
                  KeyFocusListener.keyPressed[~var1] = false;
               } else {
                  if(!KeyFocusListener.keyPressed[var1] && KeyFocusListener.field600 < KeyFocusListener.field606.length - 1) {
                     KeyFocusListener.field606[++KeyFocusListener.field600 - 1] = var1;
                  }

                  KeyFocusListener.keyPressed[var1] = true;
               }
            }
         }

         if(KeyFocusListener.field600 > 0) {
            KeyFocusListener.keyboardIdleTicks = 0;
         }

         KeyFocusListener.field610 = KeyFocusListener.field590;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1646397309"
   )
   static void method286(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = BoundingBox.method48(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = BoundingBox.method48(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method286(var0, var7 - 1, var2, var3, var4, var5);
         method286(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
