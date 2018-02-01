import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public class class299 {
   @ObfuscatedName("g")
   @Export("userHome")
   public static String userHome;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -893733006787600321L
   )
   long field3817;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -6226863011807529427L
   )
   long field3814;
   @ObfuscatedName("w")
   public boolean field3815;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -3689586959023711235L
   )
   long field3813;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -4113138891362781391L
   )
   long field3821;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -1128496827596661379L
   )
   long field3818;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 881394975
   )
   int field3819;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1379588235
   )
   int field3820;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -304816225
   )
   int field3816;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1439236943
   )
   int field3822;

   public class299() {
      this.field3817 = -1L;
      this.field3814 = -1L;
      this.field3815 = false;
      this.field3813 = 0L;
      this.field3821 = 0L;
      this.field3818 = 0L;
      this.field3819 = 0;
      this.field3820 = 0;
      this.field3816 = 0;
      this.field3822 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1532435985"
   )
   public void method5338() {
      this.field3817 = ScriptVarType.currentTimeMs();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "395984503"
   )
   public void method5339() {
      if(this.field3817 != -1L) {
         this.field3821 = ScriptVarType.currentTimeMs() - this.field3817;
         this.field3817 = -1L;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1076316868"
   )
   public void method5340(int var1) {
      this.field3814 = ScriptVarType.currentTimeMs();
      this.field3819 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2139598949"
   )
   public void method5349() {
      if(this.field3814 != -1L) {
         this.field3813 = ScriptVarType.currentTimeMs() - this.field3814;
         this.field3814 = -1L;
      }

      ++this.field3816;
      this.field3815 = true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method5341() {
      this.field3815 = false;
      this.field3820 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2061783447"
   )
   public void method5351() {
      this.method5349();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "124163353"
   )
   public void method5344(Buffer var1) {
      ItemLayer.method2564(var1, this.field3821);
      ItemLayer.method2564(var1, this.field3813);
      ItemLayer.method2564(var1, this.field3818);
      var1.putShort(this.field3819);
      var1.putShort(this.field3820);
      var1.putShort(this.field3816);
      var1.putShort(this.field3822);
   }
}
