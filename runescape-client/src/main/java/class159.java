import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class159 extends class157 {
   @ObfuscatedName("w")
   Socket field2003;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   class151 field2004;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   GameSocket field2005;

   class159(Socket var1, int var2, int var3) throws IOException {
      this.field2003 = var1;
      this.field2003.setSoTimeout(30000);
      this.field2003.setTcpNoDelay(true);
      this.field2003.setReceiveBufferSize(65536);
      this.field2003.setSendBufferSize(65536);
      this.field2004 = new class151(this.field2003.getInputStream(), var2);
      this.field2005 = new GameSocket(this.field2003.getOutputStream(), var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1138130565"
   )
   public boolean vmethod3355(int var1) throws IOException {
      return this.field2004.method3222(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "255159045"
   )
   public int vmethod3354() throws IOException {
      return this.field2004.method3227();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1722557406"
   )
   public int vmethod3353() throws IOException {
      return this.field2004.method3223();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-61239109"
   )
   public int vmethod3356(byte[] var1, int var2, int var3) throws IOException {
      return this.field2004.method3224(var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1450005148"
   )
   public void vmethod3385(byte[] var1, int var2, int var3) throws IOException {
      this.field2005.read(var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "188281095"
   )
   public void vmethod3368() {
      this.field2005.method3402();

      try {
         this.field2003.close();
      } catch (IOException var2) {
         ;
      }

      this.field2004.method3225();
   }

   protected void finalize() {
      this.vmethod3368();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1607363329"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
