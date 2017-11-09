import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("w")
public class class13 {
   @ObfuscatedName("oz")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   @Export("soundSystem1")
   static AbstractSoundSystem soundSystem1;
   @ObfuscatedName("p")
   public static Comparator field278;
   @ObfuscatedName("i")
   public static Comparator field276;
   @ObfuscatedName("j")
   public static Comparator field277;
   @ObfuscatedName("v")
   public static Comparator field274;
   @ObfuscatedName("as")
   static int[] field281;
   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field280;
   @ObfuscatedName("m")
   public final List field275;

   static {
      field278 = new class19();
      new class12();
      field276 = new class17();
      field277 = new class18();
      field274 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfv;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field275 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field275.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-55675245"
   )
   public void method82(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field275, var1);
      } else {
         Collections.sort(this.field275, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "25717011"
   )
   public static int method77(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcw;ZI)I",
      garbageValue = "-1037953388"
   )
   static int method78(int var0, Script var1, boolean var2) {
      Widget var3 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
      if(var0 == 2500) {
         class82.intStack[++class56.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class82.intStack[++class56.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class82.intStack[++class56.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class82.intStack[++class56.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class82.intStack[++class56.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class82.intStack[++class56.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "63"
   )
   static void method84(int var0) {
      if(var0 == -1 && !Client.field1088) {
         ItemLayer.method2521();
      } else if(var0 != -1 && var0 != Client.field1026 && Client.field1059 != 0 && !Client.field1088) {
         IndexData var1 = class21.indexTrack1;
         int var2 = Client.field1059;
         class210.field2594 = 1;
         class184.field2516 = var1;
         class210.field2598 = var0;
         class210.field2599 = 0;
         class37.field485 = var2;
         class210.field2595 = false;
         class47.field584 = 2;
      }

      Client.field1026 = var0;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1153212911"
   )
   static final void method83(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(CombatInfoListHolder.loadWidget(var0)) {
         RSCanvas.field630 = null;
         class41.gameDraw(class243.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(RSCanvas.field630 != null) {
            class41.gameDraw(RSCanvas.field630, -1412584499, var1, var2, var3, var4, class70.field809, ItemLayer.field1706, var7);
            RSCanvas.field630 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1055[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1055[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "16711680"
   )
   static void method81(String var0) {
      class40.sessionToken = var0;

      try {
         String var1 = class9.clientInstance.getParameter(Parameters.field3770.key);
         String var2 = class9.clientInstance.getParameter(Parameters.field3762.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class47.method771(class268.currentTimeMs() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         Client var4 = class9.clientInstance;
         String var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var4).eval(var5);
      } catch (Throwable var6) {
         ;
      }

   }
}
