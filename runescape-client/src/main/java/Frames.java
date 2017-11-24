import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("c")
   static int[] field2044;
   @ObfuscatedName("aq")
   static FontMetrics field2045;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Lep;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lid;Lid;IZ)V"
   )
   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.getChild(0, var11);
            } else {
               var13 = var2.getChild(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2002573384"
   )
   public boolean method2997(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-1481683381"
   )
   static void method3000(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ItemComposition.field3559; ++var4) {
         ItemComposition var5 = WorldMapType2.getItemDefinition(var4);
         if((!var1 || var5.field3594) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class229.field2911 = -1;
               class51.field626 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class51.field626 = var2;
      class20.field321 = 0;
      class229.field2911 = var3;
      String[] var8 = new String[class229.field2911];

      for(int var9 = 0; var9 < class229.field2911; ++var9) {
         var8[var9] = WorldMapType2.getItemDefinition(var2[var9]).name;
      }

      short[] var10 = class51.field626;
      Script.method1908(var8, var10, 0, var8.length - 1);
   }
}
