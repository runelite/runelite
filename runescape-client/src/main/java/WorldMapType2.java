import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("oy")
   static boolean field245;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 54998935
   )
   int field239;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -505905531
   )
   int field240;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 954360213
   )
   int field241;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1382559723
   )
   int field244;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 218640797
   )
   int field243;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1115779705
   )
   int field242;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Li;I)V",
      garbageValue = "-1657983190"
   )
   public void vmethod692(WorldMapData var1) {
      if(var1.minX > this.field243) {
         var1.minX = this.field243;
      }

      if(var1.field177 < this.field243) {
         var1.field177 = this.field243;
      }

      if(var1.minY > this.field242) {
         var1.minY = this.field242;
      }

      if(var1.field179 < this.field242) {
         var1.field179 = this.field242;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "1329615536"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field239 && var1 < this.field239 + this.field240?var2 >> 6 == this.field241 && var3 >> 6 == this.field244:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1150064833"
   )
   public boolean vmethod694(int var1, int var2) {
      return var1 >> 6 == this.field243 && var2 >> 6 == this.field242;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1657440355"
   )
   public int[] vmethod712(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field243 * 64 - this.field241 * 64 + var2, var3 + (this.field242 * 64 - this.field244 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhh;",
      garbageValue = "2126255726"
   )
   public Coordinates vmethod707(int var1, int var2) {
      if(!this.vmethod694(var1, var2)) {
         return null;
      } else {
         int var3 = this.field241 * 64 - this.field243 * 64 + var1;
         int var4 = this.field244 * 64 - this.field242 * 64 + var2;
         return new Coordinates(this.field239, var3, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgy;S)V",
      garbageValue = "255"
   )
   public void vmethod697(Buffer var1) {
      this.field239 = var1.readUnsignedByte();
      this.field240 = var1.readUnsignedByte();
      this.field241 = var1.readUnsignedShort();
      this.field244 = var1.readUnsignedShort();
      this.field243 = var1.readUnsignedShort();
      this.field242 = var1.readUnsignedShort();
      this.method479();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1536"
   )
   void method479() {
   }

   @ObfuscatedName("w")
   public static boolean method501(long var0) {
      return var0 != 0L && !Varbit.method4946(var0);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Lcs;",
      garbageValue = "1142826143"
   )
   static Script method495(int var0, int var1, int var2) {
      int var3 = (var1 << 8) + var0;
      Script var6 = (Script)Script.field1214.get((long)(var3 << 16));
      Script var5;
      if(var6 != null) {
         var5 = var6;
      } else {
         String var7 = String.valueOf(var3);
         int var8 = TotalQuantityComparator.indexScripts.getFile(var7);
         if(var8 == -1) {
            var5 = null;
         } else {
            label57: {
               byte[] var9 = TotalQuantityComparator.indexScripts.takeRecordFlat(var8);
               if(var9 != null) {
                  if(var9.length <= 1) {
                     var5 = null;
                     break label57;
                  }

                  var6 = class143.newScript(var9);
                  if(var6 != null) {
                     Script.field1214.put(var6, (long)(var3 << 16));
                     var5 = var6;
                     break label57;
                  }
               }

               var5 = null;
            }
         }
      }

      if(var5 != null) {
         return var5;
      } else {
         int var13 = var0 + (var2 + 40000 << 8);
         Script var15 = (Script)Script.field1214.get((long)(var13 << 16));
         Script var14;
         if(var15 != null) {
            var14 = var15;
         } else {
            String var10 = String.valueOf(var13);
            int var11 = TotalQuantityComparator.indexScripts.getFile(var10);
            if(var11 == -1) {
               var14 = null;
            } else {
               byte[] var12 = TotalQuantityComparator.indexScripts.takeRecordFlat(var11);
               if(var12 != null) {
                  if(var12.length <= 1) {
                     var14 = null;
                     return var14 != null?var14:null;
                  }

                  var15 = class143.newScript(var12);
                  if(var15 != null) {
                     Script.field1214.put(var15, (long)(var13 << 16));
                     var14 = var15;
                     return var14 != null?var14:null;
                  }
               }

               var14 = null;
            }
         }

         return var14 != null?var14:null;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-1795758851"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-54"
   )
   static final String method491(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-789706794"
   )
   static final void method498(int var0) {
      if(GameCanvas.loadWidget(var0)) {
         ItemComposition.method5125(Widget.widgets[var0], -1);
      }
   }
}
