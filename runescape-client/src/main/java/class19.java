import java.util.Comparator;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class19 implements Comparator {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static Buffer field323;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   public static BufferProvider field322;
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   static IndexedSprite[] field321;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1798391029
   )
   static int field325;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   static IndexedSprite field319;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "1554354203"
   )
   int method144(class14 var1, class14 var2) {
      return var1.field287 < var2.field287?-1:(var2.field287 == var1.field287?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method144((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Lin;",
      garbageValue = "26"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3544.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-703023597"
   )
   static void method154(String var0, String var1, String var2) {
      class93.loginMessage1 = var0;
      class93.loginMessage2 = var1;
      class93.loginMessage3 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "877061134"
   )
   static String method151() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class99.field1516.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IZIZB)V",
      garbageValue = "8"
   )
   static void method153(int var0, boolean var1, int var2, boolean var3) {
      if(class51.worldList != null) {
         Actor.method1544(0, class51.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(Lhg;Lii;IIZB)V",
      garbageValue = "27"
   )
   static final void method152(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = RSSocket.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.field1048[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }
}
