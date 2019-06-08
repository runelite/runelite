import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   @Export("itemContainers")
   static NodeHashTable itemContainers;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Lbt;"
   )
   @Export("worlds")
   static World[] worlds;
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("__bc_dm")
   static IndexCache __bc_dm;
   @ObfuscatedName("f")
   @Export("ids")
   int[] ids;
   @ObfuscatedName("q")
   @Export("quantities")
   int[] quantities;

   static {
      itemContainers = new NodeHashTable(32);
   }

   ItemContainer() {
      this.ids = new int[]{-1};
      this.quantities = new int[]{0};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1265322360"
   )
   static String method1170(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Len;",
      garbageValue = "-227230552"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)SequenceDefinition.__jh_o.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         AbstractIndexCache var3 = SequenceDefinition.__jh_f;
         AbstractIndexCache var4 = SequenceDefinition.__jh_q;
         boolean var5 = true;
         int[] var6 = var3.__j_395(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.getRecord(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.getRecord(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            SequenceDefinition.__jh_o.put(var2, (long)var0);
         }

         return var2;
      }
   }
}
