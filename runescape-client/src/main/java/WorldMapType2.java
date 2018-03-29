import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("af")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -315550853
   )
   int field498;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1790532657
   )
   int field495;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 937438677
   )
   int field496;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 88847377
   )
   int field497;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1986165799
   )
   int field503;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 589226449
   )
   int field499;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "269119455"
   )
   public void vmethod751(WorldMapData var1) {
      if(var1.minX > this.field503) {
         var1.minX = this.field503;
      }

      if(var1.field431 < this.field503) {
         var1.field431 = this.field503;
      }

      if(var1.minY > this.field499) {
         var1.minY = this.field499;
      }

      if(var1.field436 < this.field499) {
         var1.field436 = this.field499;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "520265099"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field498 && var1 < this.field498 + this.field495?var2 >> 6 == this.field496 && var3 >> 6 == this.field497:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "9376"
   )
   public boolean vmethod758(int var1, int var2) {
      return var1 >> 6 == this.field503 && var2 >> 6 == this.field499;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "174791792"
   )
   public int[] vmethod754(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field503 * 64 - this.field496 * 64 + var2, var3 + (this.field499 * 64 - this.field497 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Lim;",
      garbageValue = "-64"
   )
   public Coordinates vmethod777(int var1, int var2) {
      if(!this.vmethod758(var1, var2)) {
         return null;
      } else {
         int var3 = this.field496 * 64 - this.field503 * 64 + var1;
         int var4 = this.field497 * 64 - this.field499 * 64 + var2;
         return new Coordinates(this.field498, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-314407075"
   )
   public void vmethod756(Buffer var1) {
      this.field498 = var1.readUnsignedByte();
      this.field495 = var1.readUnsignedByte();
      this.field496 = var1.readUnsignedShort();
      this.field497 = var1.readUnsignedShort();
      this.field503 = var1.readUnsignedShort();
      this.field499 = var1.readUnsignedShort();
      this.method538();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-7"
   )
   void method538() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "8"
   )
   public static boolean method553(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class57.field646.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var11.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var10 = class53.method815(class57.field652, var2, new Object[]{(new URL(class57.field652.getCodeBase(), var0)).toString()});
            return var10 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class57.field652.getAppletContext().showDocument(new URL(class57.field652.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class57.field652;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var9) {
            ;
         }

         try {
            class57.field652.getAppletContext().showDocument(new URL(class57.field652.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "797463023"
   )
   static final void method548(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Name.loadWidget(var0)) {
         class7.method40(class189.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
