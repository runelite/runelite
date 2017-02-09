import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class20 implements Runnable {
   @ObfuscatedName("y")
   Object field210 = new Object();
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -904303661
   )
   int field211 = 0;
   @ObfuscatedName("r")
   int[] field212 = new int[500];
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 1495968633
   )
   static int field213;
   @ObfuscatedName("a")
   static String field214;
   @ObfuscatedName("k")
   boolean field215 = true;
   @ObfuscatedName("dr")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("w")
   int[] field218 = new int[500];

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "859260664"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   public void run() {
      for(; this.field215; class195.method3560(50L)) {
         Object var1 = this.field210;
         synchronized(this.field210) {
            if(this.field211 < 500) {
               this.field212[this.field211] = class115.field1799;
               this.field218[this.field211] = class115.field1794;
               ++this.field211;
            }
         }
      }

   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(LWidget;II)Ljava/lang/String;",
      garbageValue = "-1272447421"
   )
   static String method212(Widget var0, int var1) {
      int var3 = class88.method1872(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2064 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "351615913"
   )
   public static boolean method213(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
