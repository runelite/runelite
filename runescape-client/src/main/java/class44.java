import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class44 extends WorldMapData {
   @ObfuscatedName("l")
   HashSet field554;
   @ObfuscatedName("f")
   HashSet field551;
   @ObfuscatedName("q")
   List field553;

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Lgy;Lgy;Lgy;IZI)V",
      garbageValue = "-984155618"
   )
   void method603(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field554 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method164(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field554.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field551 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method620(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field551.add(var9);
      }

      this.method604(var2, var5);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(Lgy;ZI)V",
      garbageValue = "-692589603"
   )
   void method604(Buffer var1, boolean var2) {
      this.field553 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3715();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field553.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "-419307501"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = class216.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
