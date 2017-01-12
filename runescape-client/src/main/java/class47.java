import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class47 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1938265067
   )
   static int field919 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 738619833
   )
   public static int field920;
   @ObfuscatedName("i")
   static final class136 field921 = new class136();
   @ObfuscatedName("x")
   static final class121 field922 = new class121(1024);
   @ObfuscatedName("u")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 1112509549
   )
   static int field925;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)LFileOnDisk;",
      garbageValue = "-5"
   )
   public static FileOnDisk method856(String var0, String var1, boolean var2) {
      File var3 = new File(class104.field1672, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(Frames.field1561 == 33) {
         var4 = "_rc";
      } else if(Frames.field1561 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(FrameMap.field1465, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "1965269243"
   )
   static class48 method861(int var0) {
      class48 var1 = (class48)class48.field929.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class137.field1898.method3272(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class48();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2780();
            var1.field934 = var3.readUnsignedShort();
            var1.field932 = var3.readUnsignedShort();
            var1.field927 = var3.readUnsignedShort();
            var1.field931 = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2761();
            var1.field928 = new int[var4];
            var1.field935 = new int[var4];
            var1.field930 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field928[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.field930[var5] = var3.method2965();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field935[var5] = var3.method2780();
               } else {
                  var1.field935[var5] = var3.readUnsignedByte();
               }
            }

            class48.field929.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1753884524"
   )
   public static boolean method863(int var0) {
      return (var0 & 1) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1012624050"
   )
   public static boolean method864(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1702571800"
   )
   public static void method866() {
      KitDefinition.field2799.reset();
   }
}
