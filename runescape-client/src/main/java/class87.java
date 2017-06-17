import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
public class class87 {
   @ObfuscatedName("w")
   static final BigInteger field1363;
   @ObfuscatedName("z")
   static final BigInteger field1367;
   @ObfuscatedName("dx")
   @ObfuscatedGetter(
      intValue = 1115483099
   )
   static int field1373;

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
      garbageValue = "-81403821"
   )
   static final void method1599(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
         Client.menuOptions[Client.menuOptionCount] = var0;
         Client.menuTargets[Client.menuOptionCount] = var1;
         Client.menuTypes[Client.menuOptionCount] = var2;
         Client.menuIdentifiers[Client.menuOptionCount] = var3;
         Client.menuActionParams0[Client.menuOptionCount] = var4;
         Client.menuActionParams1[Client.menuOptionCount] = var5;
         if(var6) {
            Client.field1053 = Client.menuOptionCount;
         }

         ++Client.menuOptionCount;
      }

   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "0"
   )
   static boolean method1604(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class109.method1965(var0, class33.field482);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class109.method1965(var3.name, class33.field482))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class109.method1965(var3.previousName, class33.field482))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1998237863"
   )
   public static void method1605() {
      try {
         class155.field2262.method2246();

         for(int var0 = 0; var0 < XItemContainer.field771; ++var0) {
            WorldMapType3.field404[var0].method2246();
         }

         class155.field2263.method2246();
         class155.field2256.method2246();
      } catch (Exception var1) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1746430172"
   )
   public static void method1607(int var0) {
      if(class203.field2517 != 0) {
         class182.field2455 = var0;
      } else {
         class203.field2516.method3592(var0);
      }

   }

   static {
      field1363 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1367 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }
}
