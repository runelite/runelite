import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
public class class245 implements class244 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2968;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2963;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2962;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2972;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2964;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2967;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2965;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2969;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static final class245 field2970;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static final class245 field2971;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2000520293
   )
   public final int field2966;

   static {
      field2968 = new class245("", 10);
      field2963 = new class245("", 11);
      field2962 = new class245("", 12);
      field2972 = new class245("", 13);
      field2964 = new class245("", 14);
      field2967 = new class245("", 15, new ScriptVarType[]{ScriptVarType.field149, ScriptVarType.field149}, (ScriptVarType[])null);
      field2965 = new class245("", 16, new ScriptVarType[]{ScriptVarType.field149, ScriptVarType.field149}, (ScriptVarType[])null);
      field2969 = new class245("", 17, new ScriptVarType[]{ScriptVarType.field149, ScriptVarType.field149}, (ScriptVarType[])null);
      field2970 = new class245("", 73, true, true);
      field2971 = new class245("", 76, true, false);
   }

   class245(String var1, int var2) {
      this(var1, var2, false, (ScriptVarType[])null, false, (ScriptVarType[])null);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZ[Lk;Z[Lk;)V"
   )
   class245(String var1, int var2, boolean var3, ScriptVarType[] var4, boolean var5, ScriptVarType[] var6) {
      this.field2966 = var2;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I[Lk;[Lk;)V"
   )
   class245(String var1, int var2, ScriptVarType[] var3, ScriptVarType[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   class245(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (ScriptVarType[])null, var4, (ScriptVarType[])null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field2966;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lfk;",
      garbageValue = "105314233"
   )
   public static ServerPacket[] method4619() {
      return new ServerPacket[]{ServerPacket.field2303, ServerPacket.field2288, ServerPacket.field2296, ServerPacket.field2290, ServerPacket.field2291, ServerPacket.field2292, ServerPacket.field2293, ServerPacket.field2294, ServerPacket.field2295, ServerPacket.field2350, ServerPacket.field2297, ServerPacket.field2298, ServerPacket.field2299, ServerPacket.field2327, ServerPacket.field2301, ServerPacket.field2322, ServerPacket.field2352, ServerPacket.field2304, ServerPacket.field2329, ServerPacket.field2306, ServerPacket.field2307, ServerPacket.field2308, ServerPacket.field2359, ServerPacket.field2309, ServerPacket.field2311, ServerPacket.field2302, ServerPacket.field2313, ServerPacket.field2289, ServerPacket.field2315, ServerPacket.field2316, ServerPacket.field2317, ServerPacket.field2305, ServerPacket.field2319, ServerPacket.field2320, ServerPacket.field2310, ServerPacket.field2363, ServerPacket.field2323, ServerPacket.field2324, ServerPacket.field2325, ServerPacket.field2326, ServerPacket.field2332, ServerPacket.field2330, ServerPacket.field2349, ServerPacket.field2338, ServerPacket.field2342, ServerPacket.field2371, ServerPacket.field2333, ServerPacket.field2334, ServerPacket.field2335, ServerPacket.field2336, ServerPacket.field2337, ServerPacket.field2354, ServerPacket.field2339, ServerPacket.field2340, ServerPacket.field2341, ServerPacket.field2314, ServerPacket.field2343, ServerPacket.field2344, ServerPacket.field2345, ServerPacket.field2346, ServerPacket.field2347, ServerPacket.field2348, ServerPacket.field2300, ServerPacket.field2318, ServerPacket.field2351, ServerPacket.field2364, ServerPacket.field2353, ServerPacket.field2331, ServerPacket.field2355, ServerPacket.field2356, ServerPacket.field2357, ServerPacket.field2358, ServerPacket.field2362, ServerPacket.field2360, ServerPacket.field2361, ServerPacket.field2312, ServerPacket.field2321, ServerPacket.field2287, ServerPacket.field2365, ServerPacket.field2366, ServerPacket.field2367, ServerPacket.field2368, ServerPacket.field2369, ServerPacket.field2370};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;I)Z",
      garbageValue = "-1915514626"
   )
   public static boolean method4621(IndexDataBase var0, IndexDataBase var1) {
      Area.field3468 = var1;
      if(!var0.method4674()) {
         return false;
      } else {
         class153.field2124 = var0.fileCount(35);
         Area.mapAreaType = new Area[class153.field2124];

         for(int var2 = 0; var2 < class153.field2124; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.mapAreaType[var2] = new Area(var2);
               Area.mapAreaType[var2].method4878(new Buffer(var3));
               Area.mapAreaType[var2].method4880();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1487689653"
   )
   static final void method4622() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.menuBooleanArray[var1];
               Client.menuBooleanArray[var1] = Client.menuBooleanArray[var1 + 1];
               Client.menuBooleanArray[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }
}
