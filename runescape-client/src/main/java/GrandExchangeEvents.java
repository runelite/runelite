import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("f")
   @Export("__g_f")
   public static Comparator __g_f;
   @ObfuscatedName("q")
   @Export("__g_q")
   public static Comparator __g_q;
   @ObfuscatedName("w")
   @Export("__g_w")
   public static Comparator __g_w;
   @ObfuscatedName("o")
   @Export("__g_o")
   public static Comparator __g_o;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1605454211
   )
   @Export("__g_z")
   static int __g_z;
   @ObfuscatedName("hs")
   @ObfuscatedGetter(
      intValue = 1326137897
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("m")
   @Export("events")
   public final List events;

   @ObfuscatedSignature(
      signature = "(Lgr;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.__ag_302();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.__ag_302();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "1070318468"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1601363438"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatChannel();
         Messages.Messages_channels.put(Integer.valueOf(var0), var4);
      }

      Message var5 = var4.addMessage(var0, var1, var2, var3);
      Messages.Messages_hashTable.put(var5, (long)var5.count);
      Messages.Messages_queue.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method69() {
      HitSplatDefinition.HitSplatDefinition_cached.clear();
      HitSplatDefinition.__jm_o.clear();
      HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "620886402"
   )
   static int method75(int var0, Script var1, boolean var2) {
      Widget var3 = Huffman.getWidget(Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize]);
      if(var0 == 2600) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 2606) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelAngleX;
         return 1;
      } else if(var0 == 2607) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelAngleZ;
         return 1;
      } else if(var0 == 2608) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.modelAngleY;
         return 1;
      } else if(var0 == 2609) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.transparency;
         return 1;
      } else if(var0 == 2610) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.__af;
         return 1;
      } else if(var0 == 2611) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.color;
         return 1;
      } else if(var0 == 2612) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.color2;
         return 1;
      } else if(var0 == 2613) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.rectangleMode.ordinal();
         return 1;
      } else if(var0 == 2614) {
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3.__bv?1:0;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-635606409"
   )
   static final void method74(int var0, int var1) {
      if(GroundItemPile.loadWidgetGroup(var0)) {
         class30.method570(Widget.widgets[var0], var1);
      }

   }

   static {
      __g_f = new class12();
      new WorldComparator();
      __g_q = new UnitPriceComparator();
      __g_w = new class11();
      __g_o = new TotalQuantityComparator();
   }
}
