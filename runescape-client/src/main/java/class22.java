import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public class class22 extends class28 {
   @ObfuscatedName("gi")
   static ModIcon[] field346;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -1499122567
   )
   @Export("cameraYaw")
   static int cameraYaw;

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field410 == super.field410 && var2.field411 == super.field411;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;B)V",
      garbageValue = "14"
   )
   void method156(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field526.field525) {
         throw new IllegalStateException("");
      } else {
         super.field412 = var2.readUnsignedByte();
         super.field413 = var2.readUnsignedByte();
         super.field420 = var2.readUnsignedShort();
         super.field409 = var2.readUnsignedShort();
         super.field410 = var2.readUnsignedShort();
         super.field411 = var2.readUnsignedShort();
         super.field413 = Math.min(super.field413, 4);
         super.field414 = new short[1][64][64];
         super.field421 = new short[super.field413][64][64];
         super.field408 = new byte[super.field413][64][64];
         super.field419 = new byte[super.field413][64][64];
         super.field418 = new class31[super.field413][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field511.field506) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(super.field410 == var4 && var5 == super.field411) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method228(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field410 | super.field411 << 8;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "447760786"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(Frames.field2158, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class35.field514 == 33) {
         var4 = "_rc";
      } else if(class35.field514 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(GraphicsObject.field1383, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1321489045"
   )
   public static boolean method159(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
