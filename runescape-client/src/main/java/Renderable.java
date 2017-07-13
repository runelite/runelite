import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cg")
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1819144275
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "19"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cf")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1611362339"
   )
   static void method2863(Buffer var0) {
      if(Client.field942 != null) {
         var0.putBytes(Client.field942, 0, Client.field942.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            class155.field2239.seek(0L);
            class155.field2239.read(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if(var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.putBytes(var2, 0, var2.length);
      }
   }
}
