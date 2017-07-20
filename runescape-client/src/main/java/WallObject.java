import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = 745087661
   )
   static int field2088;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 541205427
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1101047643
   )
   @Export("config")
   int config;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -490277897
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -551719327
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 515348083
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 767886203
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -127976599
   )
   @Export("orientationB")
   int orientationB;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldx;",
      garbageValue = "-1805732718"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class268.field3656, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class155.field2209 == 33) {
         var4 = "_rc";
      } else if(class155.field2209 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class64.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1265754630"
   )
   public static Object method2806(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !AbstractByteBuffer.field2376) {
            try {
               DirectByteBuffer var2 = new DirectByteBuffer();
               var2.put(var0);
               return var2;
            } catch (Throwable var3) {
               AbstractByteBuffer.field2376 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "457691810"
   )
   static void method2805(int var0, int var1, int var2) {
      if(Client.field1136 != 0 && var1 != 0 && Client.field935 < 50) {
         Client.field1081[Client.field935] = var0;
         Client.field1151[Client.field935] = var1;
         Client.field1010[Client.field935] = var2;
         Client.audioEffects[Client.field935] = null;
         Client.field1148[Client.field935] = 0;
         ++Client.field935;
      }

   }
}
