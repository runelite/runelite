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
         AbstractIndexCache var2 = SequenceDefinition.__jh_f;
         AbstractIndexCache var3 = SequenceDefinition.__jh_q;
         boolean var4 = true;
         int[] var5 = var2.__j_395(var0);

         for(int var6 = 0; var6 < var5.length; ++var6) {
            byte[] var7 = var2.getRecord(var0, var5[var6]);
            if(var7 == null) {
               var4 = false;
            } else {
               int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
               byte[] var9 = var3.getRecord(var8, 0);
               if(var9 == null) {
                  var4 = false;
               }
            }
         }

         Frames var11;
         if(!var4) {
            var11 = null;
         } else {
            try {
               var11 = new Frames(var2, var3, var0, false);
            } catch (Exception var10) {
               var11 = null;
            }
         }

         if(var11 != null) {
            SequenceDefinition.__jh_o.put(var11, (long)var0);
         }

         return var11;
      }
   }

   static {
      itemContainers = new NodeHashTable(32);
   }
}
