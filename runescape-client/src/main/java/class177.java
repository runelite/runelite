import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class177 implements class158 {
   @ObfuscatedName("l")
   public static final class177 field2657 = new class177(1, 0, true, true, true);
   @ObfuscatedName("i")
   public static final class177 field2658 = new class177(2, 1, true, true, false);
   @ObfuscatedName("a")
   public final boolean field2659;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 711227801
   )
   public final int field2660;
   @ObfuscatedName("h")
   public static final class177 field2661 = new class177(5, 10, false, false, true);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 423038927
   )
   final int field2662;
   @ObfuscatedName("b")
   public static final class177 field2663 = new class177(0, -1, true, false, true);
   @ObfuscatedName("k")
   public static final class177 field2664 = new class177(4, 3, false, false, true);
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 2033608933
   )
   protected static int field2666;
   @ObfuscatedName("t")
   public static final class177 field2668 = new class177(3, 2, false, false, true);
   @ObfuscatedName("r")
   public final boolean field2670;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1877075403"
   )
   static int method3330(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class32.field729[++class101.field1648 - 1] = class16.loadWorlds()?1:0;
         return 1;
      } else {
         World var3;
         if(var0 == 6501) {
            var3 = class3.method40();
            if(var3 != null) {
               class32.field729[++class101.field1648 - 1] = var3.id;
               class32.field729[++class101.field1648 - 1] = var3.mask;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3.activity;
               class32.field729[++class101.field1648 - 1] = var3.location;
               class32.field729[++class101.field1648 - 1] = var3.playerCount;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field729[++class101.field1648 - 1] = -1;
               class32.field729[++class101.field1648 - 1] = 0;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               class32.field729[++class101.field1648 - 1] = 0;
               class32.field729[++class101.field1648 - 1] = 0;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            var3 = ItemLayer.method1520();
            if(var3 != null) {
               class32.field729[++class101.field1648 - 1] = var3.id;
               class32.field729[++class101.field1648 - 1] = var3.mask;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3.activity;
               class32.field729[++class101.field1648 - 1] = var3.location;
               class32.field729[++class101.field1648 - 1] = var3.playerCount;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = var3.address;
            } else {
               class32.field729[++class101.field1648 - 1] = -1;
               class32.field729[++class101.field1648 - 1] = 0;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               class32.field729[++class101.field1648 - 1] = 0;
               class32.field729[++class101.field1648 - 1] = 0;
               class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            World var4;
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class32.field729[--class101.field1648];
               var4 = null;

               for(var5 = 0; var5 < World.field676; ++var5) {
                  if(var7 == World.worldList[var5].id) {
                     var4 = World.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class32.field729[++class101.field1648 - 1] = var4.id;
                  class32.field729[++class101.field1648 - 1] = var4.mask;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var4.activity;
                  class32.field729[++class101.field1648 - 1] = var4.location;
                  class32.field729[++class101.field1648 - 1] = var4.playerCount;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field729[++class101.field1648 - 1] = -1;
                  class32.field729[++class101.field1648 - 1] = 0;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class32.field729[++class101.field1648 - 1] = 0;
                  class32.field729[++class101.field1648 - 1] = 0;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               class101.field1648 -= 4;
               var7 = class32.field729[class101.field1648];
               boolean var8 = class32.field729[class101.field1648 + 1] == 1;
               var5 = class32.field729[class101.field1648 + 2];
               boolean var6 = class32.field729[class101.field1648 + 3] == 1;
               if(null != World.worldList) {
                  class99.method2002(0, World.worldList.length - 1, var7, var8, var5, var6);
               }

               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field431 = class32.field729[--class101.field1648] == 1;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               var7 = class32.field729[--class101.field1648];
               if(var7 >= 0 && var7 < World.field676) {
                  var4 = World.worldList[var7];
                  class32.field729[++class101.field1648 - 1] = var4.id;
                  class32.field729[++class101.field1648 - 1] = var4.mask;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var4.activity;
                  class32.field729[++class101.field1648 - 1] = var4.location;
                  class32.field729[++class101.field1648 - 1] = var4.playerCount;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = var4.address;
               } else {
                  class32.field729[++class101.field1648 - 1] = -1;
                  class32.field729[++class101.field1648 - 1] = 0;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class32.field729[++class101.field1648 - 1] = 0;
                  class32.field729[++class101.field1648 - 1] = 0;
                  class32.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2662 = var1;
      this.field2660 = var2;
      this.field2659 = var4;
      this.field2670 = var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int vmethod4183() {
      return this.field2662;
   }
}
