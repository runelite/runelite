import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public abstract class class163 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1886445141
   )
   public int field2319;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -33677325
   )
   public int field2320;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1829333717
   )
   public int field2321;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -837280923
   )
   static int field2323;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1645708105
   )
   public int field2324;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;B)Z",
      garbageValue = "0"
   )
   public abstract boolean vmethod3055(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZS)LFileOnDisk;",
      garbageValue = "-10271"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class21.field347, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class228.field3159 == 33) {
         var4 = "_rc";
      } else if(class228.field3159 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class2.field14, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
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
}
