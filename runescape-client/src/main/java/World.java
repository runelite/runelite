import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("World")
public class World {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -146595175
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 868700873
   )
   static int field1289;
   @ObfuscatedName("s")
   static int[] field1288;
   @ObfuscatedName("w")
   static int[] field1303;
   @ObfuscatedName("rs")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   static IndexFile field1295;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[Lcx;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("i")
   static int[] field1287;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -851064925
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1832687273
   )
   @Export("index")
   int index;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1088616663
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 204879085
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @Export("address")
   String address;
   @ObfuscatedName("t")
   @Export("activity")
   String activity;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1525337225
   )
   @Export("location")
   int location;

   static {
      worldCount = 0;
      field1289 = 0;
      field1288 = new int[]{1, 1, 1, 1};
      field1303 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1483667959"
   )
   boolean method1561() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-501456260"
   )
   boolean method1524() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1314984883"
   )
   boolean method1527() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-493397043"
   )
   boolean method1521() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "143460789"
   )
   boolean method1551() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2073265342"
   )
   boolean method1520() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "54"
   )
   static final void method1562() {
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
               if(Client.field940 != -1) {
                  if(var1 == Client.field940) {
                     Client.field940 = var1 + 1;
                  } else if(1 + var1 == Client.field940) {
                     Client.field940 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfe;Lgl;I)Lgl;",
      garbageValue = "-1898535264"
   )
   static final class186 method1549(Buffer var0, class186 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class152.method2922(var2);
         var1 = new class186(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class185(var0.readString());
         } else {
            var6 = new WidgetConfig(var0.readInt());
         }

         var1.method3501((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-93"
   )
   static void method1519() {
      Object var0 = class236.field3231;
      synchronized(class236.field3231) {
         if(class236.field3233 == 0) {
            FrameMap.field2049 = new Thread(new class236());
            FrameMap.field2049.setDaemon(true);
            FrameMap.field2049.start();
            FrameMap.field2049.setPriority(5);
         }

         class236.field3233 = 600;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "407050944"
   )
   static void method1560() {
      if(class217.loadWorlds()) {
         class92.worldSelectShown = true;
      }

   }
}
