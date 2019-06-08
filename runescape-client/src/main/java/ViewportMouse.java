import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("ViewportMouse")
public class ViewportMouse {
   @ObfuscatedName("m")
   @Export("ViewportMouse_isInViewport")
   public static boolean ViewportMouse_isInViewport;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1891197573
   )
   @Export("ViewportMouse_x")
   public static int ViewportMouse_x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1535565231
   )
   @Export("ViewportMouse_y")
   public static int ViewportMouse_y;
   @ObfuscatedName("w")
   @Export("ViewportMouse_false0")
   public static boolean ViewportMouse_false0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1135175963
   )
   @Export("__dm_u")
   static int __dm_u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 262104267
   )
   @Export("__dm_g")
   static int __dm_g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2071972829
   )
   @Export("__dm_l")
   static int __dm_l;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -852671813
   )
   @Export("__dm_k")
   static int __dm_k;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2140977119
   )
   @Export("ViewportMouse_entityCount")
   public static int ViewportMouse_entityCount;
   @ObfuscatedName("a")
   @Export("ViewportMouse_entityTags")
   public static long[] ViewportMouse_entityTags;

   static {
      ViewportMouse_isInViewport = false;
      ViewportMouse_x = 0;
      ViewportMouse_y = 0;
      ViewportMouse_false0 = false;
      ViewportMouse_entityCount = 0;
      ViewportMouse_entityTags = new long[1000];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lic;",
      garbageValue = "17"
   )
   @Export("getWorldMapElement")
   public static WorldMapElement getWorldMapElement(int var0) {
      return var0 >= 0 && var0 < Widget.WorldMapElement_cached.length && Widget.WorldMapElement_cached[var0] != null?Widget.WorldMapElement_cached[var0]:new WorldMapElement(var0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "2128573585"
   )
   static int method2983(int var0, Script var1, boolean var2) {
      Widget var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
      if(var0 == 2500) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if(var0 == 2501) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if(var0 == 2502) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jg")
   @ObfuscatedSignature(
      signature = "(Lho;I)Z",
      garbageValue = "-1501258333"
   )
   static final boolean method2957(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.__client_fd = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.__client_ru.__f_386(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.__client_ru.__q_387(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.__client_ru.__w_388(false);
         }

         if(var1 == 325) {
            Client.__client_ru.__w_388(true);
         }

         if(var1 == 326) {
            PacketBufferNode var4 = Interpreter.method1915(ClientPacket.__gs_n, Client.packetWriter.isaacCipher);
            Client.__client_ru.__o_389(var4.packetBuffer);
            Client.packetWriter.__q_167(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
