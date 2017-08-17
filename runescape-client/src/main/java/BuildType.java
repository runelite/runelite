import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("RC")
   public static final BuildType RC;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("WIP")
   public static final BuildType WIP;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("LIVE")
   public static final BuildType LIVE;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("BUILD_LIVE")
   public static final BuildType BUILD_LIVE;
   @ObfuscatedName("x")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1899297931
   )
   @Export("ordinal")
   public final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lib;",
      garbageValue = "-86"
   )
   public static class255 method4099(int var0) {
      class255 var1 = (class255)class255.field3402.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class255.field3405.getConfigData(32, var0);
         var1 = new class255();
         if(var2 != null) {
            var1.method4511(new Buffer(var2));
         }

         class255.field3402.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lic;",
      garbageValue = "220747106"
   )
   public static class252 method4100(int var0) {
      class252 var1 = (class252)class252.field3379.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class252.field3375.getConfigData(11, var0);
         var1 = new class252();
         if(var2 != null) {
            var1.method4456(new Buffer(var2));
         }

         var1.method4455();
         class252.field3379.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method4101() {
      XItemContainer.itemContainers = new XHashTable(32);
   }
}
