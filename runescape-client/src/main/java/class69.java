import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
public class class69 extends Node {
   @ObfuscatedName("w")
   boolean field848;
   @ObfuscatedName("a")
   Widget field849;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -657152287
   )
   int field850;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1771681115
   )
   int field851;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1595810095
   )
   int field852;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -949540471
   )
   int field853;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1997256975
   )
   int field854;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 998892115
   )
   int field855;
   @ObfuscatedName("k")
   String field856;
   @ObfuscatedName("i")
   Object[] field857;
   @ObfuscatedName("o")
   class219 field858;
   @ObfuscatedName("v")
   Widget field859;

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "1"
   )
   static final void method1126(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class136.SINE[var6];
         var12 = class136.COSINE[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var11 * var9 + var12 * var5 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class136.SINE[var7];
         var12 = class136.COSINE[var7];
         var13 = var8 * var12 + var11 * var10 >> 16;
         var10 = var10 * var12 - var11 * var8 >> 16;
         var8 = var13;
      }

      class155.cameraX = var0 - var8;
      class60.cameraZ = var1 - var9;
      class157.cameraY = var2 - var10;
      Player.cameraPitch = var3;
      class22.cameraYaw = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass219;I)V",
      garbageValue = "1155911733"
   )
   public void method1128(class219 var1) {
      this.field858 = var1;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZI)V",
      garbageValue = "-1183703867"
   )
   static void method1131(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            WallObject.method2866(var6, var2, var3, var4);
            class14.method65(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               WorldMapType2.method546(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "903279521"
   )
   public void method1133(Object[] var1) {
      this.field857 = var1;
   }

   public class69() {
      this.field858 = class219.field2803;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "358447364"
   )
   public static byte[] method1134(Object var0, boolean var1) {
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
      } else if(var0 instanceof class176) {
         class176 var2 = (class176)var0;
         return var2.vmethod3363();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-69"
   )
   static void method1135() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3533(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3538()) {
         int var1 = var0.id;
         if(class66.method1121(var1)) {
            boolean var2 = true;
            Widget[] var3 = class46.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = PacketBuffer.method3403(var4);
               if(var5 != null) {
                  class88.method1714(var5);
               }
            }
         }
      }

   }
}
