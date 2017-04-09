import java.io.File;
import java.io.RandomAccessFile;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class6 implements Comparator {
   @ObfuscatedName("i")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1293632173"
   )
   int method71(class2 var1, class2 var2) {
      return var1.method10().compareTo(var2.method10());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;I)V",
      garbageValue = "-1116344329"
   )
   static final void method75(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2880();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2880();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var2 + var10;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class10.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class173.method3308(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static void method77() {
      if(Client.field458) {
         Widget var0 = class118.method2354(XClanMember.field284, Client.field414);
         if(var0 != null && var0.field2311 != null) {
            class18 var1 = new class18();
            var1.field207 = var0;
            var1.field199 = var0.field2311;
            class26.method565(var1);
         }

         Client.field458 = false;
         class22.method197(var0);
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method71((class2)var1, (class2)var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Ljava/io/File;",
      garbageValue = "23918"
   )
   static File method78(String var0) {
      if(!class107.field1753) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1754.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1752, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1754.put(var0, var2);
                  return var2;
               }
            } catch (Exception var7) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var6) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
